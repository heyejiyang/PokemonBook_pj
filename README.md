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
# MEMBER
| 키  | 논리     | 물리        | 도메인           | 타입    | UNIQUE | NULL허용 | 기본값     | 코멘트   | 
|:--:|--------|-----------|---------------|-------|--------|--------|---------|-------| 
| pk | 회원번호   | USER_NO   | long          | NUMBER |        | Y      |         |       |
|    | 이메일    | EMAIL     | String        | VARCHAR | Y      | N      |         |       |
|    | 비밀번호   | PASSWORD  | String        | VARCHAR |        | N      |         | 8자리이상 |
|    | 회원이름   | USER_NAME | String        | VARCHAR |        | N      |         |       |
|    | 회원타입   | USER_TYPE | USER_TYPE     | VARCHAR |        | Y      | USER    |       |
|    | 포켓몬 순서 | MY_POKEMON_SEQ  | long          | NUMBER |        | Y      | 0       |       |
|    | 생성일자   | REG_DT    | LocalDateTime | DATE  |        | Y      | SYSDATE |       |
|    | 수정일자   | MDO_DT    | LocalDateTime | DATE  |        | Y      |         |       |
 


# BOARD
키  | 논리      | 물리 | 도메인     | 타입    | UNIQUE | NULL허용 | 기본값 | 코멘트   | 
|:--:|---------|--|---------|-------|-------|--------|----|-------| 
| pk | 게시판 아이디 | BID | String  | VARCHAR |       | Y      |    |       |
|    | 게시판 이름  | BNAME | String  | VARCHAR |       | N      |    |       |
|    | 페이지 행 수 |ROWS_PER_PAGE | Int     | NUMBER |       | Y      | 20 |  |
|    | 사용여부    | ACTIVE | Boolean | NUMBER |       | Y      | 0  |       |
|    | 분류사용여부  | ACTIVE_CATEGORY | Boolean | NUMBER |       | Y      | 0  |       |
|    | 분류      | CATEGORY| String  | CLOB |       | Y      |    |       |
|    | 관리자     |AUTHORITY | String  | VARCHAR2  |       | Y      | All |       |



# BOARD_DATA
| 키  | 논리      | 물리 | 도메인     | 타입    | UNIQUE | NULL허용 | 기본값     | 코멘트   | 
|:--:|---------|----|---------|-------|--|--------|---------|-------| 
| pk | 순서      | SEQ | long    | NUMBER |  | Y      |         |       |
|    | 회원      |  BID| String  | VARCHAR |  | Y      |         |       |
|    | 비회원     | GID | String  | VARCHAR |  | Y      |         |  |
|    | 사진      | POSTER | String  | VARCHAR |  | N      |         |       |
|    | 회원순서    | MEMBER_SEQ | long    | VARCHAR |  | Y      | 0       |       |
|    | 비회원 비밀번호 | GUEST_PASSWORD | String  | VARCHAR |  | Y      |         |       |
|    | 분류      | CATEGORY | String  | VARCHAR  |  | Y      |         |       |
|    | 공지여부    | NOTICE | int     |  NUMBER |  | Y      | 0       |       |
|    | 이름      | SUBJECT | String  | VARCHAR  |  | N      |         |       |
|    | 컨텐츠     |CONTENT | String  |  CLOB    |  | N      |         |       |
|    | 브라우저 종류 정보 |   UA | String  |  VARCHAR     |  | Y      |         |       |
|    | 글 작성자 IP 주소 |  IP | String  |   VARCHAR    |  | Y      |         |       |
|    | 작성일시    |  REG_DT | LocalDateTime |  DATE     |  | Y      | SYSDATE |       |
|    | 수정일시    |  MOD_DT | LocalDateTime |   DATE    |  | Y      |         |       |


# POKEMON
 키  | 논리       | 물리                | 도메인     | 타입    | UNIQUE | NULL허용 | 기본값    | 코멘트   | 
|:--:|----------|-------------------|---------|-------|--|-------|--------|-------| 
| pk | 순서       | SEQ               | long    | NUMBER |  |       |        |       |
|    | 이름       | NAME              | String  | VARCHAR |  | N     |        |       |
|    | 몸무게      | WEIGHT            | int  | NUMBER |  |       | 0      |  |
|    | 길이       | HEIGHT            | double  | NUMBER |  |       | 0      |       |
|    | 기본경험치    | BASE_EXPERIENCE   | int    | NUMBER |  |       | 0      |       |
|    | 앞면이미지    | FRONT_IMAGE       | String  | VARCHAR |  |       |        |       |
|    | 뒷면이미지    | BACK_IMAGE        | String  | VARCHAR  |  |       |        |       |
|    | 픽셀 앞면이미지 | PIXEL_FRONT_IMAGE | String     |  VARCHAR |  |       |        |       |
|    | 픽셀 뒷면이미지 | PIXEL_BACK_IMAGE  | String  | VARCHAR |       |       |        |
|    | 원본데이터    | RAW_DATA          | String  |  CLOB    |  |       |        |       |
|    | 한국이름     | NAME_KR           | String  |  VARCHAR    |  |       |        |       |
|    | 소개       | DESCRIPTION       | String  |   VARCHAR   |  |       |        |       |
|    | 유형1      | TYPE1             | String |  VARCHAR    |  |       |  |       |
|    | 유형2      | TYPE2             | String |   VARCHAR   |  |       |        |       |





# POKEGACHA




# FILE_INFO



<BR>

# 7. 역할 분담

<BR>

# 8. 일정표
