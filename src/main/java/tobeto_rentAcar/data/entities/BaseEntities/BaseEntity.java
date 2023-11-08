package tobeto_rentAcar.data.entities.BaseEntities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
public class BaseEntity {

    @Builder.Default
    private Boolean isDeleted = false;

    @LastModifiedDate
    private Date lastModified;

    @CreatedDate
    private Date createdDate;

}