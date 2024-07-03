package org.choongang.global.filters;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.choongang.member.MemberUtil;
import org.choongang.member.entities.Member;

public class CommonRequestWrapper extends HttpServletRequestWrapper {
    public CommonRequestWrapper(ServletRequest req) {
        super((HttpServletRequest) req);

        HttpServletRequest request = (HttpServletRequest) req;

        /* 로그인 상태, 로그인 회원 정보 전역 유지 */
        boolean isLogin = MemberUtil.isLogin(request);
        Member member = MemberUtil.getMember(request);

        request.setAttribute("isLogin", isLogin);
        request.setAttribute("loggedMember", member);
    }
}