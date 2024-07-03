package org.choongang.member.services;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.choongang.global.validators.Validator;
import org.choongang.member.entities.Member;
import org.choongang.member.mapper.MemberMapper;

public class LoginService {

    private Validator<HttpServletRequest> validator;
    private MemberMapper mapper;

    public LoginService(Validator<HttpServletRequest> validator, MemberMapper mapper) {
        this.validator = validator;
        this.mapper = mapper;
    }

    public void process(HttpServletRequest request) {
        // 로그인 유효성 검사
        validator.check(request);

        // 로그인 처리  - 회원 정보 조회, 세션에 유지
        String email = request.getParameter("email");
        Member member = mapper.get(email);

        HttpSession session = request.getSession();
        session.setAttribute("member", member);
    }
}