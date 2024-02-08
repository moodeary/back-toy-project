package choonsik.backtoyproject.common.config.userDetails;

import choonsik.backtoyproject.member.entity.Member;
import choonsik.backtoyproject.member.repository.MemberRepository;
import choonsik.backtoyproject.member.role.MemberRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService {

    private final MemberRepository memberRepository;
    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {


        System.out.println("여기 들어왔니?00" + "answer2");

        Optional<Member> _member = memberRepository.findByLoginId("answer2");

        System.out.println("여기 들어왔니?11" +  _member);

        if(_member.isEmpty()) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }

        System.out.println("여기 들어왔니?22");

        Member member = _member.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        if("admin".equals(loginId)) {
            authorities.add(new SimpleGrantedAuthority(MemberRole.ADMIN.getRole()));
        } else {
            authorities.add(new SimpleGrantedAuthority(MemberRole.USER.getRole()));
        }

        System.out.println("여기 들어왔니?33" + authorities);
        System.out.println("여기 들어왔니?44" + member);

        User user = new User(member.getLoginId(), member.getPassword(), authorities);
        System.out.println("user값은 뭘까" + user);
        

        return new User(member.getLoginId(), member.getPassword(), authorities);
    }


}
