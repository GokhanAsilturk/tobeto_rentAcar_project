package tobeto_rentAcar.data.models.BaseEntities;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import tobeto_rentAcar.data.models.BaseEntities.types.UserType;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED) // kendini extend eden her klasa kendi değişkenlerini eklemesini sağlar.
public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email_address", unique = true)
    private String emailAddress;

    @Column(name = "password")
    private String password;

    @Column(name = "user_type_id")
    private UserType userType;

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
