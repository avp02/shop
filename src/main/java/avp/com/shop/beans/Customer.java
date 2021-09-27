package avp.com.shop.beans;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "Enter name please")
    @Min(value = 2, message = "Name should be more then 2 characters")
    private String name;

    @Column(nullable = false, unique = true)
    @NotNull(message = "Enter username please")
    @Min(value = 5, message = "Name should be more then 5 characters")
    private String userName;

    private String phone;
    @Email(message = "Check your email")
    @NotNull(message = "Email should not be empty")
    @Column(nullable = false)
    private String email;

//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
//    private Cart cart;
}
