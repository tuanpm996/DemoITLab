package producer.eureka.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@Entity
@Data
@Table(name = "teacher_category")
public class TeacherCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User user;
    private Date createdAt;
    private Boolean softDelete;

    public TeacherCategory(Teacher teacher, Category category) {
        this.teacher = teacher;
        this.category = category;
    }
}
