package producer.eureka.model;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@Entity
@Table(name = "teacher_schedules")
public class TeacherSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long teacherId;
    private long userId;
    private String notes;
    private String createdBy;
    private Date createdAt;
}
