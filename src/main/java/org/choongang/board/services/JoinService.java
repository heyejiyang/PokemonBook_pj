package org.choongang.board.services;

import lombok.RequiredArgsConstructor;
import org.choongang.board.controllers.RequestJoin;
import org.choongang.board.mappers.MemberMapper;
import org.choongang.board.validators.JoinValidator;
import org.choongang.global.config.annotations.Service;

@Service
@RequiredArgsConstructor
public class JoinService {
    private final JoinValidator validator;
    private final MemberMapper mapper;

    public void process(RequestJoin form) {
        validator.check(form);


    }
}
