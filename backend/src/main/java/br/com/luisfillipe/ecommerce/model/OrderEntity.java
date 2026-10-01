package br.com.luisfillipe.ecommerce.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
@Entity @Table(name="orders")
public class OrderEntity {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) private Customer customer;
 @Enumerated(EnumType.STRING) private OrderStatus status=OrderStatus.CREATED;
 private LocalDateTime createdAt=LocalDateTime.now();
 private BigDecimal total=BigDecimal.ZERO;
 @OneToMany(mappedBy="order",cascade=CascadeType.ALL,orphanRemoval=true) private List<OrderItem> items=new ArrayList<>();
 public Long getId(){return id;} public Customer getCustomer(){return customer;} public void setCustomer(Customer v){customer=v;}
 public OrderStatus getStatus(){return status;} public void setStatus(OrderStatus v){status=v;}
 public LocalDateTime getCreatedAt(){return createdAt;} public BigDecimal getTotal(){return total;} public List<OrderItem> getItems(){return items;}
 public void addItem(OrderItem item){items.add(item);item.setOrder(this);total=total.add(item.getSubtotal());}
}
