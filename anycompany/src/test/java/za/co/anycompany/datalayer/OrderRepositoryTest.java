package za.co.anycompany.datalayer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.co.anycompany.model.Order;
import za.co.anycompany.model.Customer;
import za.co.anycompany.service.OrderService;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class OrderRepositoryTest {

    @Autowired
    OrderService orderService;

    @BeforeAll
    static void setup() {

    }



    @Test
    public void loadCustomersWithLinkedOrdersTest() {
        Order order1 = new Order();
        order1.setAmount(100);
        order1.setVat(12);

        Order order2 = new Order();
        order2.setAmount(101);
        order2.setVat(13);

        List<Order> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);

        Customer customer = new Customer();
        customer.setName("Linda");
        customer.setCountry("South Sudan");
        LocalDate localDate = LocalDate.parse("2023-09-09");
        ZoneId defaultZoneId = ZoneId.systemDefault();
        customer.setDateOfBirth(Date.from(localDate.atStartOfDay(defaultZoneId).toInstant()));
        customer.setOrders(orderList);
        Customer savedCustomer = orderService.saveCustomer(customer);

        System.out.println("Number of orders after creating this one: " + orderList.size());
//        assertEquals();
        System.out.println("The number of orders for this customer: " + savedCustomer.getOrders().size());
        System.out.println("The customer id: " + savedCustomer.getId());

    }
//
    @Test
    public void placeOrderLinkedToCustomerTest() {
        Customer customer = orderService.findCustomerById(1L);
        System.out.println("Our first customer: " + customer.getName());

        Order order2 = new Order();
        order2.setAmount(103);
        order2.setVat(14);

        List<Order> orderList = new ArrayList<>();
        orderList.add(order2);

        customer.getOrders().add(order2);
        Customer updatedCustomer = orderService.saveCustomer(customer);
        System.out.println("The customer now has " + updatedCustomer.getOrders().size() + " orders");

    }

    @Test
    public void findAllTest() {
        List<Order> allOrders = orderService.findAllOrders();
        System.out.println("The number of orders: " + allOrders.size());
        assertEquals(3, allOrders.size());
    }

    @Test
    void testAssertTrue() {
        assertTrue(true);
    }

}
