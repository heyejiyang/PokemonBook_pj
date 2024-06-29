package org.choongang.admin.sevices.config;

import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Service;
import org.choongang.member.entities.Member;
import org.choongang.member.mappers.MemberMapper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AllMemberConfigInfoService {
    private final MemberMapper mapper;

    public Optional<Member> get(String email) {
        Member member = mapper.get(email);

        return Optional.ofNullable(member);
    }

//    public RequestMember getForm(String email) {
//        Member member = get(email).orElseThrow();
//
//        RequestMember form = new RequestMember();
//        form.setEmail(member.getEmail());
//        form.setUserName(member.getUserName());
//        form.setUserType(member.getUserType());
//        form.setRegDt(member.getRegDt());
//
//        return form;
//    }

    public List<Member> getList() {
        return mapper.getList();
    }
}
