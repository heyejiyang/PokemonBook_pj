package org.choongang.member.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.choongang.board.controllers.BoardSearch;
import org.choongang.board.entities.BoardData;
import org.choongang.board.exceptions.BoardNotFoundException;
import org.choongang.board.mappers.BoardDataMapper;
import org.choongang.global.ListData;
import org.choongang.global.Pagination;
import org.choongang.global.config.annotations.Service;
import org.choongang.global.config.containers.BeanContainer;
import org.choongang.global.exceptions.AlertException;
import org.choongang.member.MemberUtil;
import org.choongang.member.controllers.RequestModify;
import org.choongang.member.controllers.RequestWithdraw;
import org.choongang.member.entities.Member;
import org.choongang.member.mappers.MemberMapper;
import org.choongang.member.validators.ModifyValidator;
import org.choongang.member.validators.WithdrawValidator;
import org.mindrot.jbcrypt.BCrypt;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WithdrawService {
    private final MemberMapper mapper;
    private final WithdrawValidator validator;
    private final MemberUtil memberUtil;

    public void process(RequestWithdraw form) {
        validator.check(form);
        
        Member member = memberUtil.getMember(); //로그인한 회원 정보



        //비밀번호 해시화
        //String hash = BCrypt.hashpw(form.getPassword(), BCrypt.gensalt(12));

        if (!BCrypt.checkpw(form.getPassword(), member.getPassword())) {
            throw new AlertException("비밀번호가 올바르지 않습니다.", HttpServletResponse.SC_BAD_REQUEST);
        }

        //회원 탈퇴 처리
        mapper.withdraw(member);

        int result = mapper.withdraw(member);
        if (result > 1) {
            throw new AlertException("회원 탙뢰에 실패하였습니다.", HttpServletResponse.SC_BAD_REQUEST);
        }

        //세션 데이터 업데이트(변경된 정보가 바로 반영될 수 있게 함)
        HttpSession session = BeanContainer.getInstance().getBean(HttpSession.class);
        Member _member = mapper.get(member.getEmail());
        session.setAttribute("member", _member);
    }
}
    

