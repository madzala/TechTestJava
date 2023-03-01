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

    @Column(name="vat")
    private double vat;

    public Order() {
    }

    public Order(double amount, double vat) {
        this.amount = amount;
        this.vat = vat;
    }

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

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", amount=" + amount +
                ", VAT=" + vat +
                '}';
    }
}
