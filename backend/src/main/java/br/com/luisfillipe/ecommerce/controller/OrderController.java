package br.com.luisfillipe.ecommerce.controller;
import br.com.luisfillipe.ecommerce.model.*;
import br.com.luisfillipe.ecommerce.repository.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/orders")
public class OrderController {
 private final OrderRepository orders; private final CustomerRepository customers; private final ProductRepository products;
 public OrderController(OrderRepository o,CustomerRepository c,ProductRepository p){orders=o;customers=c;products=p;}
 @GetMapping public List<OrderEntity> all(){return orders.findAll();}
 @PostMapping @Transactional public OrderEntity create(@RequestBody OrderRequest req){
  if(req==null||req.customerId()==null||req.items()==null||req.items().isEmpty()) throw new IllegalArgumentException("Cliente e itens do pedido são obrigatórios");
  Customer c=customers.findById(req.customerId()).orElseThrow();
  OrderEntity order=new OrderEntity(); order.setCustomer(c);
  for(ItemRequest item:req.items()){
   Product p=products.findById(item.productId()).orElseThrow();
   if(item.quantity()==null||item.quantity()<1||p.getStock()<item.quantity()) throw new IllegalArgumentException("Estoque insuficiente");
   p.setStock(p.getStock()-item.quantity()); products.save(p);
   OrderItem oi=new OrderItem(); oi.setProduct(p); oi.setQuantity(item.quantity()); oi.setUnitPrice(p.getPrice()); order.addItem(oi);
  }
  return orders.save(order);
 }
 public record OrderRequest(Long customerId,List<ItemRequest> items){}
 public record ItemRequest(Long productId,Integer quantity){}
}
