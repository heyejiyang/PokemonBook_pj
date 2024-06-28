package org.choongang.member.services;

import lombok.RequiredArgsConstructor;
import org.choongang.board.entities.Board;
import org.choongang.global.config.annotations.Service;
import org.choongang.member.controllers.RequestMypage;
import org.choongang.member.entities.Member;
import org.choongang.member.mappers.MemberMapper;
import org.mindrot.jbcrypt.BCrypt;

@Service
@RequiredArgsConstructor
public class MypageService {
    private final MemberMapper mapper;

    public RequestMypage getInfo(String email) {

        Member member = mapper.get(email);
        RequestMypage form = new RequestMypage();

        form.getEmail();
        form.getUserName();
        form.getUserType();
        form.getRegDt();

        return form;
    }
}
