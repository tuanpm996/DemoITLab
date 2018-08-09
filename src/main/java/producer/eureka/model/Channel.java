package producer.eureka.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@Entity
@Data
@Table(name = "channels")
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String code;
    private String name;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Channel channel;
    @ManyToOne
    @JoinColumn(name = "created_by")
    private User user;
    private Date createdAt;
    private Boolean softDelete;
}
