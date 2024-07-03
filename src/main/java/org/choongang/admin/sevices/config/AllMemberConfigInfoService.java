package org.choongang.admin.sevices.config;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.global.ListData;
import org.choongang.global.Pagination;
import org.choongang.global.config.annotations.Service;
import org.choongang.global.config.containers.BeanContainer;
import org.choongang.member.controllers.MemberSearch;
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

    public ListData<Member> getList(MemberSearch search) {
        int page = Math.max(search.getPage(),1);
        int limit = search.getLimit();
        limit = limit <1 ? 10 : limit;

        int offset = (page -1) * limit +1;
        int endRows = offset + limit;
        search.setOffset(offset);
        search.setEndRows(endRows);

        List<Member> items = mapper.getList();

        /*Pagination 클래스 참고*/
        int total = mapper.getTotal(search);
        HttpServletRequest request = BeanContainer.getInstance().getBean(HttpServletRequest.class);
        Pagination pagination = new Pagination(page,total,10,limit,request);

        return new ListData<>(items, pagination);
    }

    public ListData<Member> getList(String email, MemberSearch search) {
        search.setEmail(email);

        return getList(search);
    }

    public ListData<Member> getList(String email){

        return getList(email, new MemberSearch());
    }
}