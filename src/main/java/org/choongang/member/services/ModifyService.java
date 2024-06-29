package org.choongang.member.services;

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

        String password = form.getPassword();
        if (password != null && !password.isBlank()) {
            String hash = BCrypt.hashpw(password, BCrypt.gensalt(12));
            member.setPassword(hash);
        }

        member.setEmail(form.getEmail());
        member.setUserName(form.getUserName());
        member.setModDt(LocalDateTime.now());

        mapper.modify(member);

        /*
        // 비밀번호 해시화
        String hash = BCrypt.hashpw(form.getPassword(), BCrypt.gensalt(12));

        // DB에 영구 저장 처리
        Member member = Member.builder()
                            .email(form.getEmail())
                            .password(hash)
                            .userName(form.getUserName())
                            .modDt(LocalDateTime.now())
                            .build();

        int result = mapper.modify(member); //DB row 수

        */

        //수정일 경우 result=0

        //if (result < 1) {
          //  throw new AlertException("회원정보 수정에 실패하였습니다.", HttpServletResponse.SC_BAD_REQUEST);
        //}
    }
}
