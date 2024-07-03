package org.choongang.member.validators;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Component;
import org.choongang.global.exceptions.AlertException;
import org.choongang.global.exceptions.UnAuthorizedException;
import org.choongang.global.validators.RequiredValidator;
import org.choongang.global.validators.Validator;
import org.choongang.member.MemberUtil;
import org.choongang.member.controllers.RequestWithdraw;
import org.choongang.member.mappers.MemberMapper;

@Component
@RequiredArgsConstructor
public class WithdrawValidator implements Validator<RequestWithdraw>, RequiredValidator {
    private final MemberUtil memberUtil;
    private final MemberMapper mapper;

    @Override
    public void check(RequestWithdraw form) {

        //로그인 상태 여부 체크
        checkTrue(memberUtil.isLogin(), new UnAuthorizedException());

        /*필수 항목 검증 S*/
        String password = form.getPassword();
        String confirmPassword = form.getConfirmPassword();
        int status = HttpServletResponse.SC_BAD_REQUEST;

        if (password != null && !password.isBlank()) {
            checkRequired(password, new AlertException("비밀번호를 입력하세요.", status));
            checkRequired(confirmPassword, new AlertException("비밀번호를 확인하세요.", status));

            /*비밀번호 및 비밀번호 확인 일치 여부*/
            checkTrue(password.equals(confirmPassword), new AlertException("비밀번호가 일치하지 않습니다.", status));
        }
        /* 필수 항목 유효성 검사 E */
    }

}
