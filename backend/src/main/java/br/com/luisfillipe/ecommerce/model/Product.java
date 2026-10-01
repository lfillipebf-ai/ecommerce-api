package br.com.luisfillipe.ecommerce.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
@Entity @Table(name="products")
public class Product {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank private String name;
 private String description;
 @PositiveOrZero private BigDecimal price;
 @PositiveOrZero private Integer stock;
 @ManyToOne(optional=false) private Category category;
 public Product(){}
 public Long getId(){return id;} public String getName(){return name;} public void setName(String v){name=v;}
 public String getDescription(){return description;} public void setDescription(String v){description=v;}
 public BigDecimal getPrice(){return price;} public void setPrice(BigDecimal v){price=v;}
 public Integer getStock(){return stock;} public void setStock(Integer v){stock=v;}
 public Category getCategory(){return category;} public void setCategory(Category v){category=v;}
}
