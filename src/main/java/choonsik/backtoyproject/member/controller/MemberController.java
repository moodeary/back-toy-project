package choonsik.backtoyproject.member.controller;


import choonsik.backtoyproject.member.dto.MemberReqDto.CreateMemberDto;
import choonsik.backtoyproject.member.entity.Member;
import choonsik.backtoyproject.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signUp")
    public ResponseEntity<?> SignUpMember(@RequestBody CreateMemberDto createMemberDto) {
        return new ResponseEntity<>(memberService.createMember(createMemberDto), HttpStatus.CREATED);
    }

    @GetMapping("/login")
    public  ResponseEntity<?> LoginMember(@AuthenticationPrincipal UserDetails userDetails) {

        System.out.println(userDetails);

        return new ResponseEntity<>("흠", HttpStatus.OK);
    }
}
