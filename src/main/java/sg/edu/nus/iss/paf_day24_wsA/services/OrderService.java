package sg.edu.nus.iss.paf_day24_wsA.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.nus.iss.paf_day24_wsA.models.Order;
import sg.edu.nus.iss.paf_day24_wsA.models.OrderDetail;
import sg.edu.nus.iss.paf_day24_wsA.repositories.OrderRepository;

@Service
public class OrderService {
    
    @Autowired
    OrderRepository orderRepository;

    public int insertOrder(Order order) {
        return orderRepository.insertOrder(order);
    }


    public boolean insertOrderDetail(OrderDetail orderDetail) {
        return orderRepository.insertOrderDetail(orderDetail);
    }


    @Transactional
    public boolean processOrder(Order order) {

        // insert the order
        int generatedOrderId = insertOrder(order);

        // insert the orderDetails
        List<OrderDetail> orderDetails = order.getOrderDetails();
        for (OrderDetail orderDetail : orderDetails) {
            orderDetail.setOrderId(generatedOrderId);
            insertOrderDetail(orderDetail);
        }

        return true;        
    }
}
