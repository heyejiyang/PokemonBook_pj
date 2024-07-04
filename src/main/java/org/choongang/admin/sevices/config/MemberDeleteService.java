package org.choongang.admin.sevices.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Service;
import org.choongang.global.config.containers.BeanContainer;
import org.choongang.global.exceptions.AlertException;
import org.choongang.member.mappers.MemberMapper;

@Service
@RequiredArgsConstructor
public class MemberDeleteService {

    private final MemberMapper mapper;

    public void process() {
        HttpServletRequest request = BeanContainer.getInstance().getBean(HttpServletRequest.class);

        String[] emails = request.getParameterValues("email");

        if (emails == null || emails.length == 0) {
            throw new AlertException("삭제할 회원을 선택하세요", HttpServletResponse.SC_BAD_REQUEST);
        }

        for (String email : emails) {
            mapper.delete(email);
        }
    }
}
