package org.choongang.board.validators.write;

import jakarta.servlet.http.HttpServletResponse;
import org.choongang.global.validators.RequiredValidator;
import org.choongang.global.validators.Validator;
import org.choongang.board.controllers.RequestBoardData;
import org.choongang.global.exceptions.AlertException;

public class BoardWriteValidator implements Validator<RequestBoardData>, RequiredValidator {

    @Override
    public void check(RequestBoardData form) {
        String bId = form.getBId();
        String subject = form.getSubject();
        int status = HttpServletResponse.SC_BAD_REQUEST;

        // 필수 항목 검증
        checkRequired(bId, new AlertException("게시판 아이디를 입력하세요.", status));
        checkRequired(subject, new AlertException("제목을 입력하세요.", status));

        // 추가적인 유효성 검사 로직 추가 가능
    }
}
