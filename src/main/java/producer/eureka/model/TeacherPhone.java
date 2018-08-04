package producer.eureka.model;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@Entity
@Table(name = "teacher_phones")
public class TeacherPhone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long teacherId;
    private int phoneNumber;
    private String createdBy;
    private Date createdAt;
    private Boolean softDelete;
}
