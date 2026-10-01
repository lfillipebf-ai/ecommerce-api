package br.com.luisfillipe.ecommerce.controller;
import br.com.luisfillipe.ecommerce.model.Category;
import br.com.luisfillipe.ecommerce.repository.CategoryRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/categories")
public class CategoryController {
 private final CategoryRepository repo;
 public CategoryController(CategoryRepository repo){this.repo=repo;}
 @GetMapping public List<Category> all(){return repo.findAll();}
 @PostMapping public Category create(@Valid @RequestBody Category c){return repo.save(c);}
}
