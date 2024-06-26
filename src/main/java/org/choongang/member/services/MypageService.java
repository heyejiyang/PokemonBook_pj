package org.choongang.member.services;

import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Service;
import org.choongang.member.mappers.MemberMapper;

@Service
@RequiredArgsConstructor
public class MypageService {
    private final MemberMapper mapper;

    public void process() {

    }

}
