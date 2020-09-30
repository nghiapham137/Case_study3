package Model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Order {
    private int orderId;
    private Date orderDate;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String customerAddress;
    private List<Inline_item> inline_items;

    public Order() {}

    public Order(Date orderDate, String customerName, String customerEmail, String customerPhone, String customerAddress, List<Inline_item> inline_items) {
        this.orderDate = orderDate;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
        this.customerAddress = customerAddress;
        this.inline_items = inline_items;
    }

    public Order(int orderId, Date orderDate, String customerName, String customerEmail, String customerPhone, String customerAddress, List<Inline_item> inline_items) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
        this.customerAddress = customerAddress;
        this.inline_items = inline_items;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public java.sql.Date getOrderDate() {
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

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public List<Inline_item> getInlineItem() {
        return inline_items;
    }

    public void setProducts(List<Inline_item> inline_items) {
        this.inline_items = inline_items;
    }
}
