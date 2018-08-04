package producer.eureka.model;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@Entity
@Table(name = "teacher_levels")
public class TeacherLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String code;
    private String name;
    private String createdBy;
    private Date createdAt;
}

