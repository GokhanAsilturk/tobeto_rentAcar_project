//package tobeto_rentAcar.data.entities.BaseEntities;
//
//import lombok.*;
//import lombok.experimental.SuperBuilder;
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedDate;
//
//import javax.persistence.Inheritance;
//import javax.persistence.InheritanceType;
//import java.util.Date;
//
//
//@AllArgsConstructor
//@NoArgsConstructor
//@SuperBuilder
//@Getter
//@Setter
//@Inheritance(strategy = InheritanceType.JOINED)
//public class BaseEntity {
//
//    @Builder.Default
//    Boolean isDeleted = false;
//
//    @LastModifiedDate
//    private Date lastModified;
//
//    @CreatedDate
//    private Date createdDate;
//
//}