package br.com.luisfillipe.ecommerce.controller;
import br.com.luisfillipe.ecommerce.model.Product;
import br.com.luisfillipe.ecommerce.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/products")
public class ProductController {
 private final ProductRepository repo;
 public ProductController(ProductRepository repo){this.repo=repo;}
 @GetMapping public List<Product> all(){return repo.findAll();}
 @GetMapping("/{id}") public Product byId(@PathVariable Long id){return repo.findById(id).orElseThrow();}
 @PostMapping public Product create(@Valid @RequestBody Product p){return repo.save(p);}
 @PutMapping("/{id}") public Product update(@PathVariable Long id,@Valid @RequestBody Product p){
  Product x=repo.findById(id).orElseThrow(); x.setName(p.getName()); x.setDescription(p.getDescription()); x.setPrice(p.getPrice()); x.setStock(p.getStock()); x.setCategory(p.getCategory()); return repo.save(x);
 }
 @DeleteMapping("/{id}") public void delete(@PathVariable Long id){repo.deleteById(id);}
}
