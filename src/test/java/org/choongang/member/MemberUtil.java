package org.choongang.member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.choongang.member.entities.Member;

public class MemberUtil {

    public static boolean isLogin(HttpServletRequest request) {

        return getMember(request) != null;
    }

    public static Member getMember(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Member member = (Member)session.getAttribute("member");

        return member;
    }
}