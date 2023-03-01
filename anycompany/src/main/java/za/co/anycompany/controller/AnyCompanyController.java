package za.co.anycompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.anycompany.model.Customer;
import za.co.anycompany.model.Order;
import za.co.anycompany.service.OrderService;

import java.util.List;

@RestController
public class AnyCompanyController {

    @Autowired
    OrderService orderService;
    @GetMapping("/")
    public String test() {
        return "API is working";
    }

    @GetMapping("/getAllCustomers")
    public List<Customer> getAllCustomers() {
        List<Customer> allCustomers = orderService.findAllCustomers();
        return allCustomers;
    }

    @GetMapping("/getCustomerById/{id}")
    public Customer getCustomerById(@PathVariable final String id) {
        return orderService.findCustomerById(Long.parseLong(id));
    }

    @PostMapping("/placeOrder")
    public String placeOrder(@RequestBody final Order order) {
        System.out.println("The amount: " + order.getAmount());
        System.out.println("The VAT: " + order.getVat());
        System.out.println(order.toString());
        orderService.saveOrder(order);
        return "Order received";
    }

    @PostMapping("/placeOrderLinkedToCustomer/{id}")
    public String placeOrderLinkedToCustomer(@RequestBody final Order order, @PathVariable final Long id) {
        System.out.println("The amount: " + order.getAmount());
        System.out.println("The VAT: " + order.getVat());
        System.out.println(order.toString());
        orderService.placeOrderForCustomer(order, id);
        return "Order received";
    }

    @PostMapping("/createCustomer")
    public String createCustomer(@RequestBody final Customer customer) {
        System.out.println("The customer name : " + customer.getName());
        System.out.println("The customer country: " + customer.getCountry());
        System.out.println("The customer date of birth: " + customer.getDateOfBirth());
        orderService.saveCustomer(customer);
        return "Customer created";
    }

//    @PatchMapping("/updateOrder")
//    public void updateOrder(@RequestBody final Order order) {
//        System.out.println(order);
//    }
//
//    @DeleteMapping("/deleteProduct/{id}")
//    public void deleteOrder(@PathVariable final String id){
//        System.out.println(id);
//    }

    @PostMapping("/loadAllCustomers")
    public String loadAllCustomers(@RequestBody List<Customer> customerList) {
        System.out.println("Customers in list" + customerList.size());
        for (Customer customer : customerList) {
            orderService.saveCustomer(customer);
        }
        return "list created";
    }
}
