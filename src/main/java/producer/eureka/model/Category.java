package producer.eureka.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Entity
@Data
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String code;

    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category categoryParent;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User user;

    @CreationTimestamp
    private Date createdAt;

    private Boolean softDelete;

}
