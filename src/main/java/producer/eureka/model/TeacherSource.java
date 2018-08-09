package producer.eureka.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@Entity
@Data
@Table(name = "sources")
public class TeacherSource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "created_by")
    private User user;
    private Date createdAt;
}
