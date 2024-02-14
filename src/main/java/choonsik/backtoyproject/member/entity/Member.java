package choonsik.backtoyproject.member.entity;


import choonsik.backtoyproject.common.baseEntity.BaseEntity;
import choonsik.backtoyproject.member.dto.MemberReqDto.CreateMemberDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

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

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birthDay", nullable = false )
    private String birthDay;

    @Column(name= "role")
    private String role;

    @Column(name = "refreshToken")
    private Date refreshToken;

    public Member(Long id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public Member (CreateMemberDto createMemberDto) {
        this.username = createMemberDto.getUsername();
        this.name = createMemberDto.getName();
        this.password = createMemberDto.getPassword();
        this.birthDay = createMemberDto.getBirthDay();
        this.role = createMemberDto.getRole();
    }

    @Override
    public String toString() {
        return "Member{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
