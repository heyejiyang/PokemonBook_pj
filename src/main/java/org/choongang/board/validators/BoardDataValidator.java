package org.choongang.board.validators;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.choongang.board.controllers.RequestBoardData;
import org.choongang.board.mappers.BoardDataMapper;
import org.choongang.global.config.annotations.Component;
import org.choongang.global.exceptions.AlertException;
import org.choongang.global.validators.RequiredValidator;
import org.choongang.global.validators.Validator;

@Component
@RequiredArgsConstructor
public class BoardDataValidator implements Validator<RequestBoardData>, RequiredValidator{
    private final BoardDataMapper mapper;

    @Override
    public void check(RequestBoardData form) {
        String subject = form.getSubject();
        String content = form.getContent();
        int status = HttpServletResponse.SC_BAD_REQUEST;

        //필수 항목 검증 - 제목, 내용
        checkRequired(subject, new AlertException("게시글 제목을 입력하세요", status));
        checkRequired(content, new AlertException("게시글 내용을 입력하세요.", status));
    }
}
