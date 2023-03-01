package za.co.anycompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.anycompany.datalayer.CustomerRepository;
import za.co.anycompany.datalayer.OrderRepository;
import za.co.anycompany.model.Customer;
import za.co.anycompany.model.Order;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
//    private OrderRepository orderRepository = new OrderRepository();

    @Autowired
    public OrderRepository orderRepository;

    @Autowired
    public CustomerRepository customerRepository;

    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    public Customer findCustomerById(Long id) {
        return customerRepository.findById(Long.valueOf(id)).get();
    }
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Order placeOrderForCustomer(Order order, Long customerId ) {
        Customer customer= customerRepository.findById(customerId).get();
        customer.getOrders().add(order);
        customerRepository.saveAndFlush(customer);
        return order;
    }
//
//    public boolean placeOrder(Order order, int customerId)
//    {
//        Optional<Customer> customer = customerRepository.findById((long)customerId);
//
//
//        if (order.getAmount() == 0)
//            return false;
//
//        if (customer.get().getCountry() == "UK")
//            order.setVAT(0.2d);
//        else
//            order.setVAT(0);
//
//        orderRepository.save(order);
//
//        return true;
//    }
}
