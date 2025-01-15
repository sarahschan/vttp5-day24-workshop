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


    @Override
    public String toString() {
        return "OrderSummary [orderId=" + orderId + ", orderDate=" + orderDate + ", customerName=" + customerName
                + ", shipAddress=" + shipAddress + ", notes=" + notes + ", fullOrderDetails=" + fullOrderDetails
                + ", tax=" + tax + ", orderTotalBeforeTax=" + orderTotalBeforeTax + ", orderTotalAfterTax="
                + orderTotalAfterTax + "]";
    }


    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getShipAddress() {
        return shipAddress;
    }
    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public List<FullOrderDetail> getFullOrderDetails() {
        return fullOrderDetails;
    }
    public void setFullOrderDetails(List<FullOrderDetail> fullOrderDetails) {
        this.fullOrderDetails = fullOrderDetails;
    }
    public float getTax() {
        return tax;
    }
    public void setTax(float tax) {
        this.tax = tax;
    }
    public float getOrderTotalBeforeTax() {
        return orderTotalBeforeTax;
    }
    public void setOrderTotalBeforeTax(float orderTotalBeforeTax) {
        this.orderTotalBeforeTax = orderTotalBeforeTax;
    }
    public float getOrderTotalAfterTax() {
        return orderTotalAfterTax;
    }
    public void setOrderTotalAfterTax(float orderTotalAfterTax) {
        this.orderTotalAfterTax = orderTotalAfterTax;
    }

}
