package choonsik.backtoyproject.member.controller;


import choonsik.backtoyproject.member.dto.MemberReqDto.CreateMemberDto;
import choonsik.backtoyproject.member.entity.Member;
import choonsik.backtoyproject.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<?> SignUpMember(@RequestBody CreateMemberDto createMemberDto) {
        Member member = memberService.createMember(createMemberDto);
        return new ResponseEntity<>(member, HttpStatus.CREATED);
    }

    @GetMapping("/getMember")
    public ResponseEntity<?> SignUpMember0() {
        Member member = memberService.loginMember();
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @GetMapping("/admin")
    public ResponseEntity<?> admin() {
        return new ResponseEntity<>("admin controller", HttpStatus.OK);
    }
}
