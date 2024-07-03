package org.choongang.member.services;

import jakarta.servlet.http.HttpServletRequest;
import org.choongang.global.exceptions.BadRequestException;
import org.choongang.global.validators.Validator;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.entities.Member;
import org.choongang.member.mapper.MemberMapper;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Objects;

// 회원 가입 기능
public class JoinService {

    private Validator<RequestJoin> validator;
    private MemberMapper mapper;

    public JoinService(Validator<RequestJoin> validator, MemberMapper mapper) {
        this.validator = validator;
        this.mapper = mapper;
    }

    public void process(RequestJoin form) {

        // 유효성 검사
        validator.check(form);

        // 비밀번호 해시화 - BCrypt
        String hash = BCrypt.hashpw(form.getPassword(), BCrypt.gensalt(12));

        Member member = new Member();
        member.setEmail(form.getEmail());
        member.setPassword(hash);
        member.setUserName(form.getUserName());

        int result = mapper.register(member);
        if (result < 1) {
            throw new BadRequestException("회원가입에 실패하였습니다.");
        }

    }

    public void process(HttpServletRequest request) {
        // Objects.requiredNonNullElse(객체, null일때 기본값);
        String _termsAgree = Objects.requireNonNullElse(request.getParameter("termsAgree"), "false");
        boolean termsAgree = Boolean.parseBoolean(_termsAgree);

        RequestJoin form = RequestJoin.builder()
                .email(request.getParameter("email"))
                .password(request.getParameter("password"))
                .confirmPassword(request.getParameter("confirmPassword"))
                .userName(request.getParameter("userName"))
                .termsAgree(termsAgree)
                .build();

        process(form);

    }
}