package avp.com.shop.beans;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
//@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name's size should be from 2 to 30 characters")
    @Column(nullable = false, unique = true)
    private String name;

    @NotEmpty(message = "Description should not be empty")
    @Size(min = 2, max = 30, message = "Name's size should be from 2 to 30 characters")
    @Column(nullable = false)
    private String description;

    @NotEmpty(message = "Price should not be empty")
    @Min(value = 1, message = "The price should not be equals 0")
    @Column(nullable = false)
    private Double price;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Cart> carts;

}
