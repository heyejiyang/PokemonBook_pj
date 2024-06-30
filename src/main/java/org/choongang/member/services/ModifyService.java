package org.choongang.member.services;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Service;
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

        Member member = memberUtil.getMember(); //로그인한 회원 정보

//        String email = member.getEmail();
//        if (email != null && !email.isBlank() && !email.equals(form.getEmail())){
//            member.setEmail(form.getEmail());
//        } else {
//            member.setEmail(email);
//        }

        member.setEmail(form.getEmail());

        String password = form.getPassword();
        if (password != null && !password.isBlank()) {
            String hash = BCrypt.hashpw(password, BCrypt.gensalt(12));
            member.setPassword(hash);
        }

        member.setUserName(form.getUserName());
        member.setModDt(LocalDateTime.now());

//        try {
            mapper.modify(member);
//        } catch (AlertException e) {
//            throw new AlertException("회원정보 수정에 실패하였습니다.", HttpServletResponse.SC_BAD_REQUEST);
//        }
    }
}
