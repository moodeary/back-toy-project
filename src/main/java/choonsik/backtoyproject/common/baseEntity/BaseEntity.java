package choonsik.backtoyproject.common.baseEntity;


import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;



import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @CreatedDate
    @Column(name = "createAt", updatable = false)
    private LocalDateTime createAt;

    @LastModifiedDate
    @Column(name = "updateAt")
    private LocalDateTime updateAt;
}
