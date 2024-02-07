//package choonsik.backtoyproject.common.config.userDetails;
//
//import choonsik.backtoyproject.member.entity.Member;
//import choonsik.backtoyproject.member.repository.MemberRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//
//@Service
//@RequiredArgsConstructor
//public class PrincipalDetailsService implements UserDetailsService {
//
//    private final MemberRepository memberRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
//
//        Optional<Member> memberOptional = memberRepository.findByLoginId(loginId);
//        Member member = memberOptional.orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + loginId));
//        return new PrincipalDetails(member);
//    }
//}
