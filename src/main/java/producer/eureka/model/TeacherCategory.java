package producer.eureka.model;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@Entity
@Table(name = "teacher_categories")
public class TeacherCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long teacherId;
    private long categoryId;
    private String createdBy;
    private Date createdAt;
    private Boolean softDelete;
}
