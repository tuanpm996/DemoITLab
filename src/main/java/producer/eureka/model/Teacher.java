package producer.eureka.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Entity
@Data
@Table(name = "teachers")
public class Teacher {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "khong ten")
    private String name;

    private String teacherId;

    @NotNull(message = "can not null")
    private String info;

    private String facebook;

    @ManyToOne( fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "province")
    @NotNull
    private Province province;

    private int mktOrderId;

    @ManyToOne( fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "channel")
    private Channel channel;

    @ManyToOne( fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "source")
    private TeacherSource teacherSource;

    @ManyToOne
    @JoinColumn(name = "level")
    private TeacherLevel teacherLevel;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @OneToMany(mappedBy = "teacher")
    @JsonManagedReference
    private List<TeacherCategory> teacherCategories;

    @Transient
    private List<Category> categories;

    private String email;

    private String phone;

    @CreationTimestamp
    private Date createdAt;

    private Boolean softDelete;
}
