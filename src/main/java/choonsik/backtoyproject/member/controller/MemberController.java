package choonsik.backtoyproject.member.controller;


import choonsik.backtoyproject.member.dto.MemberReqDto.CreateMemberDto;
import choonsik.backtoyproject.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signUp")
    public ResponseEntity<?> SignUpMember(@RequestBody CreateMemberDto createMemberDto) {

        System.out.println("회원가입 로직 탐" + createMemberDto.toString());
        return new ResponseEntity<>(memberService.createMember(createMemberDto), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public  ResponseEntity<?> LoginMember(@RequestBody CreateMemberDto createMemberDto) {
        System.out.println("로그인 로직 탐");
        return new ResponseEntity<>(memberService.loginMember(createMemberDto), HttpStatus.OK);
    }
}
