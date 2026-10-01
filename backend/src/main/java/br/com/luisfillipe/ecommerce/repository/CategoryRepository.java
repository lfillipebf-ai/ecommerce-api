package br.com.luisfillipe.ecommerce.repository;
import br.com.luisfillipe.ecommerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CategoryRepository extends JpaRepository<Category,Long>{}
