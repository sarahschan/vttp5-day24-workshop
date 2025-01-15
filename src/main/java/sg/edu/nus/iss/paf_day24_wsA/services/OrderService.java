package sg.edu.nus.iss.paf_day24_wsA.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.nus.iss.paf_day24_wsA.models.FullOrderDetail;
import sg.edu.nus.iss.paf_day24_wsA.models.Order;
import sg.edu.nus.iss.paf_day24_wsA.models.OrderDetail;
import sg.edu.nus.iss.paf_day24_wsA.models.OrderSummary;
import sg.edu.nus.iss.paf_day24_wsA.repositories.OrderRepository;
import sg.edu.nus.iss.paf_day24_wsA.util.OrderUtil;

@Service
public class OrderService {
    
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderUtil orderUtil;

    public int insertOrder(Order order) {
        return orderRepository.insertOrder(order);
    }


    public boolean insertOrderDetail(OrderDetail orderDetail) {
        return orderRepository.insertOrderDetail(orderDetail);
    }


    @Transactional
    public int processOrder(Order order) {

        // insert the order
        int generatedOrderId = insertOrder(order);

        // insert the orderDetails
        List<OrderDetail> orderDetails = order.getOrderDetails();
        for (OrderDetail orderDetail : orderDetails) {
            orderDetail.setOrderId(generatedOrderId);
            insertOrderDetail(orderDetail);
        }

        return generatedOrderId;
    }


    public OrderSummary createOrderSummary(Order order, int orderId) {

        List<FullOrderDetail> fullOrderDetails = getFullOrderDetails(orderId);
        float beforeTax = orderUtil.calculateOrderTotalBeforeTax(fullOrderDetails);
        float afterTax = orderUtil.calculateOrderTotalAfterTax(beforeTax, order.getTax());

        OrderSummary orderSummary = new OrderSummary();
            orderSummary.setOrderId(orderId);
            orderSummary.setOrderDate(order.getOrderDate());
            orderSummary.setCustomerName(order.getCustomerName());
            orderSummary.setShipAddress(order.getShipAddress());
            orderSummary.setNotes(order.getNotes());
            orderSummary.setFullOrderDetails(fullOrderDetails);
            orderSummary.setTax(order.getTax());
            orderSummary.setOrderTotalBeforeTax(beforeTax);
            orderSummary.setOrderTotalAfterTax(afterTax);

        return orderSummary;
    }


    public List<FullOrderDetail> getFullOrderDetails(int orderId){

        return orderRepository.getFullOrderDetails(orderId);
    }

}
