package com.assignment.gadgetmart.repository.impl;

import com.assignment.gadgetmart.domain.dto.Order;
import com.assignment.gadgetmart.domain.dto.OrderDetail;
import com.assignment.gadgetmart.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author Rusiru
 */
@Repository
public class OrderRepositoryImpl implements OrderRepository {
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
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
        return null;
    }
    
    private int insertOrderDeatil(OrderDetail orderDetail, String orderId){
        String sql = "INSERT INTO `supervis_shopping_cart`.`order_detail` (`order_id`, `product_id`, `qty`, `amount`) VALUES" +
                " (?, ?, ?, ?)";
        final PreparedStatementCreator psc = new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
                final PreparedStatement ps = connection.prepareStatement(sql,
                        Statement.RETURN_GENERATED_KEYS);
            
                ps.setString(1, orderId);
                ps.setString(2, Long.toString(orderDetail.getProduct().getId()));
                ps.setString(3, orderDetail.getQty());
                ps.setString(4, Double.toString(orderDetail.getAmount()));
            
                return ps;
            }
        };
    
        KeyHolder keyHolder = new GeneratedKeyHolder();
    
        jdbcTemplate.update(psc, keyHolder);
    
        long insertedId = keyHolder.getKey().longValue();
    
        return (int)insertedId;
    }
    
    private int createOrder(Order order){
        
        String sql = "INSERT INTO `supervis_shopping_cart`.`order` ( `amount`, `customer_id`, `status_id`) VALUES ( ?, ?, ?);";
        final PreparedStatementCreator psc = new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
                final PreparedStatement ps = connection.prepareStatement(sql,
                        Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, Double.toString(order.getAmount()));
                ps.setString(2, order.getCustomer().getCustomerId());
                ps.setString(3, order.getCustomer().getCustomerId());
                return ps;
            }
        };
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(psc, keyHolder);
        long insertedId = keyHolder.getKey().longValue();
        return (int)insertedId;
    }
    
    
}
