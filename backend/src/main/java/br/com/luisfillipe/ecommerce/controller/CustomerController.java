package br.com.luisfillipe.ecommerce.controller;
import br.com.luisfillipe.ecommerce.model.Customer;
import br.com.luisfillipe.ecommerce.repository.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/customers")
public class CustomerController {
 private final CustomerRepository repo;
 public CustomerController(CustomerRepository repo){this.repo=repo;}
 @GetMapping public List<Customer> all(){return repo.findAll();}
 @PostMapping public Customer create(@Valid @RequestBody Customer c){return repo.save(c);}
}
