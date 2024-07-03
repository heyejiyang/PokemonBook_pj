package org.choongang.member.validators;

import org.choongang.global.exceptions.BadRequestException;
import org.choongang.global.validators.EmailValidator;
import org.choongang.global.validators.RequiredValidator;
import org.choongang.global.validators.Validator;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.exceptions.DuplicatedMemberException;
import org.choongang.member.mapper.MemberMapper;

public class JoinValidator implements Validator<RequestJoin>, RequiredValidator, EmailValidator {

    private MemberMapper mapper;

    public JoinValidator(MemberMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void check(RequestJoin form) {
        String email = form.getEmail();
        String password = form.getPassword();
        String confirmPassword = form.getConfirmPassword();
        String userName = form.getUserName();
        boolean termsAgree = form.isTermsAgree();

        /* 필수 항목 검증 - 이메일, 비밀번호, 비밀번호 확인, 회원명, 약관 동의 */
        checkRequired(email, new BadRequestException("이메일을 입력하세요."));
        checkRequired(password, new BadRequestException("비밀번호를 입력하세요."));
        checkRequired(confirmPassword, new BadRequestException("비밀번호를 확인하세요."));
        checkRequired(userName, new BadRequestException("회원명을 입력하세요."));
        checkTrue(termsAgree, new BadRequestException("약관에 동의하세요."));

        // 비밀번호, 비밀번호 확인 일치 여부
        checkTrue(password.equals(confirmPassword), new BadRequestException("비밀번호가 일치하지 않습니다."));

        // 이메일 형식 체크
        if (!checkEmail(email)) {
            throw new BadRequestException("이메일 형식이 아닙니다.");
        }

        // 비밀번호 자리수 체크
        checkTrue(password.length() >= 8, new BadRequestException("비밀번호는 8자리 이상 입력하세요."));

        // 이미 가입된 회원인지 체크
        checkTrue(mapper.exist(email) == 0L, new DuplicatedMemberException());
    }
}