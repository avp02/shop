package avp.com.shop.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    @NotEmpty(message = "Enter name please")
    @Size(min = 2, max = 30, message = "Name should be should be between from 2 to 30 characters")
    private String name;

    @Column(nullable = false, unique = true)
    @NotEmpty(message = "Enter username please")
    @Size(min = 2, max = 30, message = "UserName should be between from 2 to 30 characters")
    private String userName;

    @NotEmpty(message = "Phone should not be empty")
    @Size(min = 3, max = 30, message = "Phone should be between from 3 to 30 characters")
    @Column(nullable = false)
    private String phone;

    @Email(message = "Check your email")
    @NotEmpty(message = "Email should not be empty")
    @Column(nullable = false)
    private String email;
}
