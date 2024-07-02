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

    public List<Member> getList() {
        return mapper.getList();
    }
}