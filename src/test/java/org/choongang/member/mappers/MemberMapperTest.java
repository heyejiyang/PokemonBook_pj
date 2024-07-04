package org.choongang.member.mappers;

import com.github.javafaker.Faker;
import jakarta.servlet.http.HttpServletRequest;
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
import static org.mockito.Mockito.mock;

public class MemberMapperTest {

    private SqlSession session;
    private MemberMapper mapper;
    private Member member;

    @BeforeEach
    void init() {
        session = DBConn.getSession(false);
        mapper = session.getMapper(MemberMapper.class);
    }

    @Test
    @DisplayName("회원 등록, 조회 테스트")
    void registerTest() {
        Faker faker = new Faker(Locale.ENGLISH);

        member = Member.builder()
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

    @Test
    @DisplayName("회원 수정 테스트")
    void modifyTest() {
        // 등록된 멤버 객체를 가져와서 수정 테스트에 사용
//        assertNotNull(member); // 등록된 멤버 객체가 null이 아닌지 확인

        Faker faker = new Faker(Locale.ENGLISH);

        member = Member.builder()
                .email(System.currentTimeMillis() + faker.internet().emailAddress())
                .password(faker.regexify("\\w{8,16}").toLowerCase())
                .userName(faker.name().fullName())
                .userType(UserType.USER)
                .regDt(LocalDateTime.now())
                .build();

        //위의 회원 등록 테스트에서 생성한 객체 사용
        int result1 = mapper.register(member);
        assertEquals(1, result1); // 등록 성공 확인

        Member member1 = Member.builder()
                .email(member.getEmail()) // 기존 회원의 이메일로 설정
                .password(faker.regexify("\\w{8,16}").toLowerCase()) // 새로운 패스워드 생성
                .userName(faker.name().fullName()) // 새로운 사용자 이름 생성
                .modDt(LocalDateTime.now()) // 수정 시간 설정
                .build();

        // 회원 정보 수정
        int result = mapper.modify(member1); // 수정
        assertEquals(1, result);  // 수정 성공 확인

    }

    @Test
    @DisplayName("회원 탈퇴 테스트")
    void withdrawTest() {
        // 등록된 멤버 객체를 가져와서 탈퇴 테스트에 사용
//        assertNotNull(member); // 등록된 멤버 객체가 null이 아닌지 확인(필수)

        Faker faker = new Faker(Locale.ENGLISH);

        member = Member.builder()
                .email(System.currentTimeMillis() + faker.internet().emailAddress())
                .password(faker.regexify("\\w{8,16}").toLowerCase())
                .userName(faker.name().fullName())
                .userType(UserType.USER)
                .regDt(LocalDateTime.now())
                .build();

        Member member2 = Member.builder()
                .email(member.getEmail()) // 기존 회원의 이메일로 설정
                .password(member.getPassword()) // 기존 비번으로 설정
                .build();


        // 회원 탈퇴
        int result = mapper.withdraw(member2);
        assertEquals(0, result); // 탈퇴 성공 확인
    }

    @Test
    @DisplayName("회원 강퇴 테스트")
    void memberDeleteTest() {

        Faker faker = new Faker(Locale.ENGLISH);

        member = Member.builder()
                .email(System.currentTimeMillis() + faker.internet().emailAddress())
                .password(faker.regexify("\\w{8,16}").toLowerCase())
                .userName(faker.name().fullName())
                .userType(UserType.USER)
                .regDt(LocalDateTime.now())
                .build();

        Member member2 = Member.builder()
                .email(member.getEmail()) // 기존 회원의 이메일로 설정
                .password(member.getPassword()) // 기존 비번으로 설정
                .build();

        // 회원 강퇴
        HttpServletRequest request = mock(HttpServletRequest.class);

        String[] emails = request.getParameterValues("email");

        if (emails != null) {
            for (String email : emails) {
                mapper.delete(email);
            }
        }
    }

    @AfterEach
    void destroy() {
        session.rollback();
    }
}