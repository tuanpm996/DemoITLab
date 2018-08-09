package producer.eureka.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import producer.eureka.validation.annotation.CheckTeacherPhone;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "teacher_phones")
public class TeacherPhone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @CheckTeacherPhone
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User user;

    @CreationTimestamp
    private Date createdAt;

    private Boolean softDelete;
}
