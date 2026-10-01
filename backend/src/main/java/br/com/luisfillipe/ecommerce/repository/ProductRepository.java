package br.com.luisfillipe.ecommerce.repository;
import br.com.luisfillipe.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepository extends JpaRepository<Product,Long>{}
