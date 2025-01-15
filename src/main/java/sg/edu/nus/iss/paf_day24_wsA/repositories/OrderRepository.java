package sg.edu.nus.iss.paf_day24_wsA.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.paf_day24_wsA.models.exceptions.*;
import sg.edu.nus.iss.paf_day24_wsA.models.FullOrderDetail;
import sg.edu.nus.iss.paf_day24_wsA.models.Order;
import sg.edu.nus.iss.paf_day24_wsA.models.OrderDetail;

@Repository
public class OrderRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public int insertOrder(Order order) {
        
        KeyHolder keyHolder = new GeneratedKeyHolder();

        PreparedStatementCreator psc = new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                
                PreparedStatement ps = con.prepareStatement(Queries.SQL_INSERT_ORDER, Statement.RETURN_GENERATED_KEYS);
                    ps.setDate(1, order.getOrderDate());
                    ps.setString(2, order.getCustomerName());
                    ps.setString(3, order.getShipAddress());
                    ps.setString(4, order.getNotes());
                    ps.setFloat(5, order.getTax());

                return ps;
            }
        };

        jdbcTemplate.update(psc, keyHolder);

        int generatedOrderId = keyHolder.getKey().intValue();

        if (generatedOrderId <= 0) {
            throw new UnableToInsertOrderException("Unable to insert order into DB");
        }

        return generatedOrderId;

    }


    public boolean insertOrderDetail(OrderDetail orderDetail) {
    
        try {
            
            jdbcTemplate.update(Queries.SQL_INSERT_ORDERDETAIL,
                                orderDetail.getProduct(),
                                orderDetail.getUnitPrice(),
                                orderDetail.getDiscount(),
                                orderDetail.getQuantity(),
                                orderDetail.getOrderId());

            return true;

        } catch (DataAccessException error) {
            throw new UnableToInsertOrderDetailException("Unable to insert order detail in DB");
        }
        
    }


    public List<FullOrderDetail> getFullOrderDetails(int orderId) {
        
        try {

            SqlRowSet rs = jdbcTemplate.queryForRowSet(Queries.SQL_GET_FULL_ORDER_DETAIL_BY_ID, orderId);

            List<FullOrderDetail> fullOrderDetails = new ArrayList<>();

            while (rs.next()){
                fullOrderDetails.add(FullOrderDetail.toFullOrderDetail(rs));
            }

            return fullOrderDetails;

        } catch (DataAccessException error) {
            throw new UnableToRetrieveFullOrderDetailsException("Unable to retrieve full order details for order ID " + orderId);
        }
    }
}
