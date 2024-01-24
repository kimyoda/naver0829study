package data.controller;

import data.dto.MemberDto;
import data.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import security.setting.JwtTokenProvider;
import security.setting.UserAuthentication;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class LoginController {
    private final PasswordEncoder passwordEncoder;

    private final MemberService memberService;

    @PostMapping("/login/auth")
    public Map<String, Object> login(@RequestBody MemberDto dto) {
        Map<String, Object> map = new HashMap<>();

        MemberDto dto2 = memberService.getLogin(dto.getMyid());

        boolean isPasswordCorrect = false;
        if (dto2 == null) {
            // 해당 아이디가 없는 경우
            map.put("result", "noid");
        } else {
            // 해당 아이디가 있는 경우
            // 비번을 얻어야 한다.
            String dbPass = dto2.getPass();

            // 입력한 비번과 db의 암호화된 비번이 맞을 경우
            // result에는 success로 보낸다
            // 근데 비번이 틀린경우는 result dp "nopass"
            String pass = dto.getPass(); // 로그인 시 입력한 비번
            isPasswordCorrect = passwordEncoder.matches(pass, dbPass);
        }
        String myid = dto.getMyid();

        if (isPasswordCorrect) {
            // 비번이 맞는 경우
            map.put("result", "success");
            // 토큰을 얻어보자
            Authentication auth = new UserAuthentication(myid, null, null);
            String token = JwtTokenProvider.generateToken(auth, myid);
            System.out.println("token=" + token);

            map.put("token", token);
        } else {
            // 비번이 틀린경우
            map.put("result", "nopass");
        }

        return map;
    }
}
