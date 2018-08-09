package producer.eureka.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@Entity
@Data
@Table(name = "teacher_levels")
public class TeacherLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private String name;
    @ManyToOne
    @JoinColumn(name = "created_by")
    private User user;
    private Date createdAt;
}

