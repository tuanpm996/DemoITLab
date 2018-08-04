package producer.eureka.model;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@Entity
@Table(name = "role_groups")
public class RoleGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long roleId;
    private long groupId;
    private String createdBy;
    private Date createdAt;
}
