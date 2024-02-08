package choonsik.backtoyproject.member.entity;


import choonsik.backtoyproject.common.BaseEntity.BaseEntity;
import choonsik.backtoyproject.member.dto.MemberReqDto.CreateMemberDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "member")
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "loginId", nullable = false)
    private String loginId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birthDay", nullable = false )
    private String birthDay;

    @Column(name = "password", nullable = false)
    private String password;


    public Member (CreateMemberDto createMemberDto) {
        this.loginId = createMemberDto.getLoginId();
        this.name = createMemberDto.getName();
        this.password = createMemberDto.getPassword();
        this.birthDay = createMemberDto.getBirthDay();
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", loginId='" + loginId + '\'' +
                ", name='" + name + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
