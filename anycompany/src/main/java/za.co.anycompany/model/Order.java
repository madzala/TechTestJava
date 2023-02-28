package za.co.anycompany.model;

import javax.persistence.*;

@Entity
@Table(name="CUSTOMER_ORDER")
public class Order {
    @Id
    @GeneratedValue
    @Column(name="id")
    private int orderId;

    //@Column(name="AMOUNT")
    private double amount;

    //@Column(name="VAT")
    private double VAT;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getVAT() {
        return VAT;
    }

    public void setVAT(double VAT) {
        this.VAT = VAT;
    }
}
