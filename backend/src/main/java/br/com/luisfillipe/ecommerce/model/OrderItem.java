package br.com.luisfillipe.ecommerce.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
@Entity @Table(name="order_items")
public class OrderItem {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) private OrderEntity order;
 @ManyToOne(optional=false) private Product product;
 private Integer quantity; private BigDecimal unitPrice;
 public Long getId(){return id;} public Product getProduct(){return product;} public void setProduct(Product v){product=v;}
 public Integer getQuantity(){return quantity;} public void setQuantity(Integer v){quantity=v;}
 public BigDecimal getUnitPrice(){return unitPrice;} public void setUnitPrice(BigDecimal v){unitPrice=v;}
 public BigDecimal getSubtotal(){return unitPrice.multiply(BigDecimal.valueOf(quantity));}
 public void setOrder(OrderEntity v){order=v;}
}
