package sg.edu.nus.iss.paf_day24_wsA.models;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class FullOrderDetail {
    
    private int id;
    private String product;
    private float unitPrice;
    private float discount;
    private float discountPrice;
    private int quantity;
    private float itemPrice;
    
    public FullOrderDetail() {
    }
    
    public FullOrderDetail(int id, String product, float unitPrice, float discount, float discountPrice, int quantity,
            float itemPrice) {
        this.id = id;
        this.product = product;
        this.unitPrice = unitPrice;
        this.discount = discount;
        this.discountPrice = discountPrice;
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    
    @Override
    public String toString() {
        return "FullOrderDetail [id=" + id + ", product=" + product + ", unitPrice=" + unitPrice + ", discount="
                + discount + ", discountPrice=" + discountPrice + ", quantity=" + quantity + ", itemPrice=" + itemPrice
                + "]";
    }

    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getProduct() {
        return product;
    }
    public void setProduct(String product) {
        this.product = product;
    }
    public float getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }
    public float getDiscount() {
        return discount;
    }
    public void setDiscount(float discount) {
        this.discount = discount;
    }
    public float getDiscountPrice() {
        return discountPrice;
    }
    public void setDiscountPrice(float discountPrice) {
        this.discountPrice = discountPrice;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public float getItemPrice() {
        return itemPrice;
    }
    public void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
    }

    
    public static FullOrderDetail toFullOrderDetail(SqlRowSet rs) {
        
        FullOrderDetail fod = new FullOrderDetail();
            fod.setId(rs.getInt("id"));
            fod.setProduct(rs.getString("product"));
            fod.setUnitPrice(rs.getFloat("unitPrice"));
            fod.setDiscount(rs.getFloat("discount"));
            fod.setDiscountPrice(rs.getFloat("discountPrice"));
            fod.setQuantity(rs.getInt("quantity"));
            fod.setItemPrice(rs.getFloat("itemPrice"));

        return fod;
    }
}
