package avp.com.shop.beans;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @NotNull(message = "Name should not be empty")
    @Column(nullable = false, unique = true)
    private String name;

    @NotNull(message = "Description should not be empty")
    @Min(value = 10, message = "Description should be more 10 characters")
    @Column(nullable = false)
    private String description;

    @NotNull(message = "Price should not be empty")
    @Column(nullable = false)
    private Double price;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Cart> carts;

}
