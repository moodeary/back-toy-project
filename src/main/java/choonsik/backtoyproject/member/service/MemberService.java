package choonsik.backtoyproject.member.service;

import choonsik.backtoyproject.member.dto.MemberReqDto.CreateMemberDto;
import choonsik.backtoyproject.member.entity.Member;
import choonsik.backtoyproject.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Member createMember(CreateMemberDto dto) {

        boolean exists = memberRepository.existsByUsername(dto.getUsername());

        if (exists) {
            throw new RuntimeException("이미 아이디가 존재합니다.");
        }

        //비밀번호 암호화
        String encPassword = passwordEncoder.encode(dto.getPassword());

        // 객체에 반영
        Member member = Member.builder()
                .username(dto.getUsername())
                .name(dto.getName())
                .birthDay(dto.getBirthDay())
                .password(encPassword)
                .role(dto.getRole())
                .build();

        System.out.println("member.toString()" + member.toString());

        return memberRepository.save(member);
    }

    @Transactional
    public Member loginMember() {

        String username = "";
        Member findMember = memberRepository.findByUsername(username).orElseThrow();

        return findMember;
    }
}
