package producer.eureka.model;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@Entity
@Table(name = "channels")
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String code;
    private String name;
    private String parentId;
    private String createdBy;
    private Date createdAt;
}
