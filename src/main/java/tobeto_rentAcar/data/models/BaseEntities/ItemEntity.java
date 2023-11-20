package tobeto_rentAcar.data.models.BaseEntities;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import tobeto_rentAcar.data.models.BaseEntities.types.ItemType;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder
@Table(name = "items")
@Inheritance(strategy = InheritanceType.JOINED)
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JoinColumn(name = "item_type_id")
    private ItemType itemType;

    @Builder.Default
    @Column(name = "is_deleted")
    private boolean isDeleted = false;

    @LastModifiedDate
    @Column(name = "last_modified")
    private Date lastModified;


    @CreatedDate
    @Column(name = "created_date")
    private Date createdDate;


}
