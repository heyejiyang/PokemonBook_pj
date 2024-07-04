package org.choongang.member.mappers;

import com.github.javafaker.Faker;
import org.apache.ibatis.session.SqlSession;
import org.choongang.global.config.DBConn;
import org.choongang.member.constants.UserType;
import org.choongang.member.entities.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemberMapperTest {

    private SqlSession session;
    private MemberMapper mapper;

    @BeforeEach
    void init() {
        session = DBConn.getSession(false);
        mapper = session.getMapper(MemberMapper.class);
    }

    @Test
    @DisplayName("회원 등록, 조회 테스트")
    void registerTest() {
        Faker faker = new Faker(Locale.ENGLISH);
        Member member = Member.builder()
                .email(System.currentTimeMillis() + faker.internet().emailAddress())
                .password(faker.regexify("\\w{8,16}").toLowerCase())
                .userName(faker.name().fullName())
                .userType(UserType.USER)
                .regDt(LocalDateTime.now())
                .build();

        int result = mapper.register(member); // 등록
        assertEquals(1, result);

        long cnt = mapper.exists(member.getEmail()); // 등록 회원 있는지 테스트
        assertEquals(1L, cnt);

        Member member2 = mapper.get(member.getEmail()); // 이메일로 조회되는 회원이 있는지 테스트
        assertEquals(member.getEmail(), member2.getEmail());
    }

    @AfterEach
    void destroy() {
        session.rollback();
    }
}
