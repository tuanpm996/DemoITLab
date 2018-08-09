package producer.eureka.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "teacher_emails")
public class TeacherEmail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @Email(message = "loi email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User user;

    private Date createdAt;

    private Boolean softDelete;
}
