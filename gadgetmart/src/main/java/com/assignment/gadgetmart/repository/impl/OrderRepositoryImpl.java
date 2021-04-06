package com.assignment.gadgetmart.repository.impl;

import com.assignment.gadgetmart.domain.dto.Customer;
import com.assignment.gadgetmart.domain.dto.Order;
import com.assignment.gadgetmart.domain.dto.OrderDetail;
import com.assignment.gadgetmart.domain.dto.Product;
import com.assignment.gadgetmart.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;

/**
 * @author Rusiru
 */
@Repository
public class OrderRepositoryImpl implements OrderRepository {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    @Override
    public Order placeOrder(Order order) {
        order.setOrderId(createOrder(order));
        for (OrderDetail orderDetail: order.getOrderDetail()) {
            orderDetail.setOrderDetailId(insertOrderDeatil(orderDetail, Integer.toString(order.getOrderId())));
        }
        return order;
    }
    
    @Override
    public List<Order> getAllOrders(String email) {
        String sql = "SELECT * FROM order1 o , customer c where o.customer_id = c.customerId";
        return namedParameterJdbcTemplate.query(sql, Collections.singletonMap("email", email), (resultSet, rowNum) -> {
            Order order = new Order();
            order.setOrderId(resultSet.getInt("orderId"));
            order.setAmount(resultSet.getDouble("amount"));
            Customer customer = new Customer();
            customer.setName(resultSet.getString("name"));
            customer.setEmail(resultSet.getString("email"));
            customer.setAddress(resultSet.getString("address"));
            order.setCustomer(customer);

            String sql1 = "SELECT * FROM `web-service-assignment-db`.orderdetail where order_id = :orderId";
            List<OrderDetail> orderDetailList = namedParameterJdbcTemplate.query(sql1, Collections.singletonMap("orderId", resultSet.getInt("orderId")), (rs, rn) -> {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrderDetailId(rs.getInt("orderDetailId"));
                orderDetail.setAmount(rs.getDouble("amount"));
                orderDetail.setItemId(rs.getString("product_id"));
                orderDetail.setQty(rs.getString("qty"));

                Product product = new Product();
                product.setName(rs.getString("item_name"));
                product.setId(rs.getString("product_id"));
                product.setUnitPrice(rs.getDouble("amount"));

                orderDetail.setProduct(product);
                return orderDetail;
            });
            order.setOrderDetail(orderDetailList);
            return order;
        });
    }
    
    private int insertOrderDeatil(OrderDetail orderDetail, String orderId){
        String sql = "INSERT INTO `web-service-assignment-db`.`orderdetail` (`order_id`, `product_id`, `qty`, `amount`, `item_id`,`item_name`) VALUES" +
                " (?, ?, ?, ?,?, ?)";
        final PreparedStatementCreator psc = new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
                final PreparedStatement ps = connection.prepareStatement(sql,
                        Statement.RETURN_GENERATED_KEYS);
            
                ps.setString(1, orderId);
                ps.setString(2, orderDetail.getProduct().getId());
                ps.setString(3, orderDetail.getQty());
                ps.setString(4, Double.toString(orderDetail.getAmount()));
                ps.setString(5, orderDetail.getItemId());
                ps.setString(6, orderDetail.getProduct().getName());

                return ps;
            }
        };
    
        KeyHolder keyHolder = new GeneratedKeyHolder();
    
        jdbcTemplate.update(psc, keyHolder);
    
        long insertedId = keyHolder.getKey().longValue();
    
        return (int)insertedId;
    }
    
    private int createOrder(Order order){
        
        String sql = "INSERT INTO `web-service-assignment-db`.`order1` ( `amount`, `customer_id`, `status_id`) VALUES ( ?, ?, ?)";
        final PreparedStatementCreator psc = new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
                final PreparedStatement ps = connection.prepareStatement(sql,
                        Statement.RETURN_GENERATED_KEYS);
                ps.setDouble(1, order.getAmount());
                ps.setInt(2, Integer.parseInt(order.getCustomer().getCustomerId()));
                ps.setInt(3, 1);
                return ps;
            }
        };
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(psc, keyHolder);
        long insertedId = keyHolder.getKey().longValue();
        return (int)insertedId;
    }
    
    
}
