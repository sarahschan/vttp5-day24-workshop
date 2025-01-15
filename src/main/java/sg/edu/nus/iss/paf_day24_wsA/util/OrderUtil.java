package sg.edu.nus.iss.paf_day24_wsA.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import sg.edu.nus.iss.paf_day24_wsA.models.Order;
import sg.edu.nus.iss.paf_day24_wsA.models.OrderDetail;

@Component
public class OrderUtil {
    
    public Order createOrder(MultiValueMap<String, String> orderData){
        
        String orderDate = orderData.getFirst("orderDate");
        String customerName = orderData.getFirst("customerName");
        String shipAddress = orderData.getFirst("shipAddress");
        String notes = orderData.getFirst("notes");
        float tax = Float.parseFloat(orderData.getFirst("tax"));

        List<OrderDetail> orderDetails = extractOrderDetails(orderData);
        
        Order order = new Order();
            order.setOrderDate(java.sql.Date.valueOf(orderDate));
            order.setCustomerName(customerName);
            order.setShipAddress(shipAddress);
            order.setNotes(notes);
            order.setTax(tax);
            order.setOrderDetails(orderDetails);

        return order;
    }

    
    public List<OrderDetail> extractOrderDetails(MultiValueMap<String, String> orderData) {
        
        List<String> products = orderData.get("orderDetails[][product]");
        List<String> unitPrices = orderData.get("orderDetails[][unitPrice]");
        List<String> discounts = orderData.get("orderDetails[][discount]");
        List<String> quantities = orderData.get("orderDetails[][quantity]");

        List<OrderDetail> orderDetails = new ArrayList<>();
        
        if (products != null) {
            for (int i = 0; i < products.size(); i++){
                OrderDetail detail = new OrderDetail();
                    detail.setProduct(products.get(i));
                    detail.setUnitPrice(Float.parseFloat(unitPrices.get(i)));
                    detail.setDiscount(Float.parseFloat(discounts.get(i)));
                    detail.setQuantity(Integer.parseInt(quantities.get(i)));
                orderDetails.add(detail);
            }
        }

        return orderDetails;
    }
}
