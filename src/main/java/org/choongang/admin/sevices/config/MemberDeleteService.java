package org.choongang.admin.sevices.config;

import lombok.RequiredArgsConstructor;
import org.choongang.board.exceptions.BoardNotFoundException;
import org.choongang.global.config.annotations.Service;
import org.choongang.member.entities.Member;
import org.choongang.member.mappers.MemberMapper;

@Service
@RequiredArgsConstructor
public class MemberDeleteService {
    private final MemberMapper mapper;
    private final AllMemberConfigInfoService infoService;

    public void delete(String email) {
        Member member = infoService.get(email).orElseThrow(BoardNotFoundException::new);
        mapper.delete(email);

    }
}
