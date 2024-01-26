package choonsik.backtoyproject.member.entity;


import choonsik.backtoyproject.member.dto.MemberReqDto;
import choonsik.backtoyproject.member.dto.MemberReqDto.CreateMemberDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "member")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "loginId", nullable = false)
    private String loginId;

    @Column(name = "nickName", nullable = false)
    private String nickName;

    @Column(name = "password", nullable = false)
    private String password;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updateAt;

    public Member (CreateMemberDto createMemberDto) {

        this.loginId = createMemberDto.getLoginId();
        this.nickName = createMemberDto.getNickName();
        this.password = createMemberDto.getPassword();
    }
}
