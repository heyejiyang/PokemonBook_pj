package org.choongang.member.validators;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Component;
import org.choongang.global.exceptions.AlertException;
import org.choongang.global.exceptions.UnAuthorizedException;
import org.choongang.global.validators.EmailValidator;
import org.choongang.global.validators.RequiredValidator;
import org.choongang.global.validators.Validator;
import org.choongang.member.MemberUtil;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.controllers.RequestModify;
import org.choongang.member.mappers.MemberMapper;

@Component
@RequiredArgsConstructor
public class ModifyValidator implements Validator<RequestModify>, RequiredValidator, EmailValidator {

    private final MemberUtil memberUtil;
    private final MemberMapper mapper;

    @Override
    public void check(RequestModify form) {

        //로그인 상태 여부 체크
        checkTrue(memberUtil.isLogin(), new UnAuthorizedException());

        /*필수 항목 검증 S*/
//        String email = form.getEmail();
        String password = form.getPassword();
        String confirmPassword = form.getConfirmPassword();
        String userName = form.getUserName();
        int status = HttpServletResponse.SC_BAD_REQUEST;

        /* 필수 항목 유효성 검사 S */
//        checkRequired(email, new AlertException("이메일을 입력하세요", status));

        // 이메일 형식 체크
//        checkTrue(checkEmail(email), new AlertException("이메일 형식이 아닙니다.", status));

        if (password != null && !password.isBlank()) {
            checkRequired(password, new AlertException("비밀번호를 입력하세요.", status));
            checkRequired(confirmPassword, new AlertException("비밀번호를 확인하세요.", status));

            checkTrue(password.length() >= 8, new AlertException("비밀번호는 8자리 이상 입력하세요.", status));

            checkTrue(password.equals(confirmPassword), new AlertException("비밀번호가 일치하지 않습니다.", status));
        }
        checkRequired(userName, new AlertException("회원명을 입력하세요.", status));
        /* 필수 항목 유효성 검사 E */


        // 이메일 중복 여부 체크 - 이미 가입된 회원인지 여부
//        checkTrue(mapper.exists(email) == 0L, new AlertException("이미 가입된 이메일입니다.", status));
    }
}