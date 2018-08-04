package producer.eureka.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "teachers")
@Getter
@Setter
public class Teacher {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String info;
    private String facebook;
    private long provinceId;
    private long mktOrderId;
    private long chanelId;
    private long sourceId;
    private long levelId;
    private String createdBy;
    private Date createdAt;
    private Boolean softDelete;
}
