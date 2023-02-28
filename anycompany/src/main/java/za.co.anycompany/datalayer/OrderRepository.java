package za.co.anycompany.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.anycompany.model.Customer;
import za.co.anycompany.model.Order;

import java.sql.*;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
    public List<Order> findAll();
    public Order saveAndFlush(Order order);
}
