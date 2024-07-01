package org.choongang.member.services;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Service;
import org.choongang.global.config.containers.BeanContainer;
import org.choongang.global.exceptions.AlertException;
import org.choongang.member.MemberUtil;
import org.choongang.member.controllers.RequestModify;
import org.choongang.member.entities.Member;
import org.choongang.member.mappers.MemberMapper;
import org.choongang.member.validators.ModifyValidator;
import org.mindrot.jbcrypt.BCrypt;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ModifyService {
    private final MemberMapper mapper;
    private final ModifyValidator validator;
    private final MemberUtil memberUtil;

    public void process(RequestModify form) {
        validator.check(form);
        
        String password = form.getPassword();
        String userName = form.getUserName();

        Member member = memberUtil.getMember(); //로그인한 회원 정보

        if (password != null && !password.isBlank()) {
            String hash = BCrypt.hashpw(password, BCrypt.gensalt(12));
            member.setPassword(hash);
        }

        member.setUserName(userName);

        //회원 정보 수정 처리
        mapper.modify(member);
        //회원 정보 수정 실패 시 오류 알림 메세지 에외처리는 불가..

        //세션 데이터 업데이트(변경된 정보가 바로 반영될 수 있게 함)
        HttpSession session = BeanContainer.getInstance().getBean(HttpSession.class);
        Member _member = mapper.get(member.getEmail());
        session.setAttribute("member", _member);
    }
}
