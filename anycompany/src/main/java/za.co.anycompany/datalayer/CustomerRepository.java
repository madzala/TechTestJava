package za.co.anycompany.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.anycompany.model.Customer;
import za.co.anycompany.model.Order;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    public List<Customer> findAll();

    public Customer saveAndFlush(Customer customer);

}
