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
### 관리자페이지 기능 목록
- 회원 관리
- 게시판 관리

### 회원 관리
- 회원 조회
### 게시판 관리
  - 게시판을 생성, 수정, 삭제하는 게시판 관리용 테이블 "BOARD"
    - 게시판 아이디
    - 게시판 이름
    - 1페이지 행수
    - 게시판 사용 여부
    - 게시판 분류
    - 게시판 권한 설정(글쓰기/글수정 권한)
    - 게시판 별 게시글은 게시판 아이디로 구분
      ex) BID = 'notice' -> BNAME = '공지사항'
    
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
- 게시글 관리 폼 (각 게시판 별로 목록 띄우기 - 관리자 로그인 된 상태로, 모든 게시글에 접근 권한 부여되어있음)
- 게시글 등록, 수정, 삭제 가능

<BR>

## 🔹 사용자(회원) 페이지
### 로그인
- 비밀번호는 암호화(hashing) 과정 거쳐 DB에 저장
### 회원가입
- EMAIL : 이메일 형식으로 작성되었는지 확인, 중복 여부 확인
- PASSWORD : 8자리 이상의 비밀번호인지 확인
### 마이페이지
- 회원 정보 조회 및 수정

<BR>

## 🔹 게시글
- 권한
    - ADMIN/USER/GUEST 권한별 게시글 접근 권한 부여
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
## COMMENTS
<BR>

# 7. 역할 분담

<BR>

# 8. 일정표
