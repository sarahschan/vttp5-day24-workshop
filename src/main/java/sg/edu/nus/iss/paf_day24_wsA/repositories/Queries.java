package sg.edu.nus.iss.paf_day24_wsA.repositories;

public class Queries {
    
    public static final String SQL_INSERT_ORDER = 
        """
            insert into orders
                (order_date, customer_name, ship_address, notes, tax)
            values
                (?, ?, ?, ?, ?)        
        """;

    
    public static final String SQL_INSERT_ORDERDETAIL = 
        """
            insert into order_details
                (product, unit_price, discount, quantity, order_id)
            values
                (?, ?, ?, ?, ?)
        """;


    public static final String SQL_GET_FULL_ORDER_DETAIL_BY_ID = 
        """
            select id,
                   product,
                   unit_price as unitPrice,
                   discount,
                   discount_price as discountPrice,
                   quantity,
                   quantity * discount_Price as itemPrice
            from (
                select id,
                       product,
                       unit_price,
                       discount,
                       unit_price * (1 - discount) as discount_price,
                       quantity
                  from order_details
                  where order_id = ?
            ) as subquery;
        """;
}
