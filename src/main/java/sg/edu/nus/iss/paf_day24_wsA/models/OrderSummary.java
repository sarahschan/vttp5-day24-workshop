package sg.edu.nus.iss.paf_day24_wsA.models;

import java.sql.Date;
import java.util.List;

public class OrderSummary {
    
    private int orderId;
    private Date orderDate;
    private String customerName;
    private String shipAddress;
    private String notes;
    private List<FullOrderDetail> fullOrderDetails;
    private float tax;
    private float orderTotalBeforeTax;
    private float orderTotalAfterTax;

    
    public OrderSummary() {
    }
    
}
