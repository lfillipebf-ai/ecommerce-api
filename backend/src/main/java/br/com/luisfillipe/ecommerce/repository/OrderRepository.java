package br.com.luisfillipe.ecommerce.repository;
import br.com.luisfillipe.ecommerce.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OrderRepository extends JpaRepository<OrderEntity,Long>{}
