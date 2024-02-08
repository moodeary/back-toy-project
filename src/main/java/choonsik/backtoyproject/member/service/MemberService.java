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

        boolean isIdExists = memberRepository.findByLoginId(dto.getLoginId()).isPresent();
        if (isIdExists) {
            throw new RuntimeException("이미 아이디가 존재합니다.");
        }

        System.out.println("dto.toString()" + dto.toString());

//         비밀번호 암호화
        String encPassword = passwordEncoder.encode(dto.getPassword());
//        System.out.println("encPassword" + encPassword);
//
//        // 객체에 반영
        Member member = Member.builder()
                .loginId(dto.getLoginId())
                .name(dto.getName())
                .birthDay(dto.getBirthDay())
                .password(encPassword)
                .build();
//
//        Member member = new Member(dto);
        System.out.println("member.toString()" + member.toString());

        return memberRepository.save(member);
    }

    @Transactional
    public Member loginMember(CreateMemberDto saveDto) {
        Member findMember = memberRepository.findByLoginId(saveDto.getLoginId()).orElseThrow(() -> new RuntimeException("===================  존재하지 않는 계정입니다.  ==================="));

        String encPassword = passwordEncoder.encode(saveDto.getPassword());

        System.out.println(findMember.getPassword());
        System.out.println(encPassword);




        if (!findMember.getPassword().equals(encPassword)) {
            throw new RuntimeException("===================  비밀번호가 다릅니다.  ===================");
        }
        return findMember;
    }
}
