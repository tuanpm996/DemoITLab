package producer.eureka.model;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private int phoneNumber;
    private String info;
    private long groupId;
    private String createdBy;
    private Date createdAt;
    private Boolean softDelete;
}
