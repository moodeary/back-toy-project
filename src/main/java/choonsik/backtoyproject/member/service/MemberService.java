package choonsik.backtoyproject.member.service;

import choonsik.backtoyproject.member.dto.MemberReqDto;
import choonsik.backtoyproject.member.dto.MemberReqDto.CreateMemberDto;
import choonsik.backtoyproject.member.entity.Member;
import choonsik.backtoyproject.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Member createMember(CreateMemberDto createMemberDto) {

        boolean isIdExists = memberRepository.findByLoginId(createMemberDto.getLoginId()).isPresent();
        if (isIdExists) {
            throw new RuntimeException("이미 아이디가 존재합니다.");
        }

        Member member = new Member(createMemberDto);
        return memberRepository.save(member);
    }

    @Transactional
    public Member loginMember(CreateMemberDto saveDto) {
        Member findMember = memberRepository.findByLoginId(saveDto.getLoginId()).orElseThrow(() -> new RuntimeException("존재하지 않는 리뷰입니다."));

        if (!findMember.getPassword().equals(saveDto.getPassword())) {
            throw new RuntimeException("비밀번호가 다름");
        }
        return findMember;
    }
}
