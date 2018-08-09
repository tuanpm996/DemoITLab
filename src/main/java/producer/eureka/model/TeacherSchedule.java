package producer.eureka.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@Entity
@Data
@Table(name = "teacher_schedules")
public class TeacherSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    private String notes;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private Date createdAt;
}
