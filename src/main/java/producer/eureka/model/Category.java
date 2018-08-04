package producer.eureka.model;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String code;
    private String name;
    private String parentId;
    private String createdBy;
    private Date createedAt;
    private Boolean softDelete;
}
