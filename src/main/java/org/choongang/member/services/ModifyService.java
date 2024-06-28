package org.choongang.member.services;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Service;
import org.choongang.global.exceptions.AlertException;
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

    public void process(RequestModify form) {
        validator.check(form);

        // 비밀번호 해시화
        String hash = BCrypt.hashpw(form.getPassword(), BCrypt.gensalt(12));

        // DB에 영구 저장 처리
        Member member = Member.builder()
                .email(form.getEmail())
                .password(hash)
                .userName(form.getUserName())
                .modDt(LocalDateTime.now())
                .build();

        //System.out.println(member); //member에 데이터가 제대로 들어가는지 확인용

        int result = mapper.modify(member); //DB row 수
//        if (result < 1) {
//            throw new AlertException("회원정보 수정에 실패하였습니다.", HttpServletResponse.SC_BAD_REQUEST);
//        }
    }
}
