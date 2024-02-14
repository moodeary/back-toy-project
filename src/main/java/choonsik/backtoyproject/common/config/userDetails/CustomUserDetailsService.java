package choonsik.backtoyproject.common.config.userDetails;

import choonsik.backtoyproject.member.entity.Member;
import choonsik.backtoyproject.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member findMember = memberRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("===================  존재하지 않는 계정입니다.  ==================="));;

        if(findMember != null) {
            return new CustomUserDetails(findMember);
        }
        return null;
    }
}
