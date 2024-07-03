![main_logo](https://github.com/heyejiyang/PokemonBook_pj/assets/163953938/0d95ae0a-eec6-439e-83bc-0d3d37dff59a)
# 😎 포켓몬 도감 프로젝트 ✌
# 1. 프로젝트 소개
### 🔹 개요
- 프로젝트명 : 포켓몬 도감 프로젝트(?)
### 🔹 기획 배경 및 기대 효과
<BR>

# 2. 개발 환경
- Intelli J
- Gradle
- java
- GitHub
- Oracle
- Apache Tomcat
  <BR>

# 3. UserFlow 작성
<BR>

# 4. 기능 명세서
## 🔹 관리자 페이지
### 설정
- 회원 관리
- 게시판 관리
### 회원 관리
- 권한 변경
- 회원 조회
- 회원 탈퇴
### 게시판 관리
  - 게시판을 생성, 수정, 삭제 하는 게시판 관리용 테이블 "BOARD" 생성
    - 게시판 아이디
    - 게시판 이름
    - 1페이지 행수
    - 게시판 사용 여부
    - 게시판 분류
    - 게시판 권한 설정(글쓰기/글수정 권한)
    - 게시판 별 게시글은 게시판 아이디로 구분
      ex) notice -> 공지사항
    ```
    CREATE TABLE BOARD{
        BID VARCHAR2(30) PRIMARY KEY,
        BNAME VARCHAR2(60) NOT NULL,
        ROWS_PER_PAGE NUMBER(4) DEFAULT 20,
        ACTIVE NUMBER(1) DEFAULT 0,
        ACTIVE_CATEGORY NUMBER(1) DEFAULT 0, 
        CATEGORY CLOB,
        AUTHORITY VARCHAR2(10) DEFAULT 'ALL' 
            CHECK(AUTHORITY IN ('ALL', 'USER', 'ADMIN'))
    };
    ```
    
### 게시글 관리
- 게시글 작성 폼(?)
- 게시글 삭제
- 
<BR>

## 🔹 회원
### 공통
### 로그인
### 회원가입
### ID 찾기
### 비밀번호 찾기
### 마이페이지

<BR>

## 🔹 게시글
### 게시글 검색
- 제목, 작성자, 내용으로 조회
### 파일 업로드 & 다운로드

<BR>

## 🔹 포켓몬 도감
### 포켓몬 조회하기
포켓몬 테이블
```
CREATE TABLE POKEMON (
   SEQ NUMBER(10) PRIMARY KEY,
   NAME VARCHAR2(60) NOT NULL,
   WEIGHT NUMBER(7) DEFAULT 0,
   HEIGHT NUMBER(7) DEFAULT 0,
   BASE_EXPERIENCE NUMBER(10) DEFAULT 0,
   FRONT_IMAGE VARCHAR2(150),
   BACK_IMAGE VARCHAR2(150),
   RAW_DATA CLOB,
   NAME_KR VARCHAR2(60),
   DESCRIPTION VARCHAR2 (1000));
```

<BR>

# 5. ERD 작성 (엔티티 관계도)

<BR>

# 6. 테이블 다이어그램
## MEMBER
## BOARD
## BOARD_DATA

<BR>

# 7. 역할 분담

<BR>

# 8. 일정표
