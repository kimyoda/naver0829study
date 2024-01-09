--------------- BOARD_FREE
CREATE TABLE BOARD_FREE (
    BOARD_FREE_ID          INT          NOT NULL AUTO_INCREMENT COMMENT '게시판 ID',
    BOARD_FREE_CRDT        TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '게시날짜',
    BOARD_FREE_CRDT_MODIFY TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정날짜',
    BOARD_FREE_USER_ID     VARCHAR(20)  NOT NULL COMMENT '유저ID',
    BOARD_FREE_TITLE       VARCHAR(50)  NOT NULL COMMENT '게시판 제목',
    BOARD_FREE_CONTENT     VARCHAR(255) NOT NULL COMMENT '게시판 내용',
    BOARD_FREE_VIEW_CNT    INT                   DEFAULT '0' COMMENT '게시판 조회수',
    BOARD_FREE_DELETE_YN   BOOLEAN               DEFAULT FALSE COMMENT '게시판 삭제여부 Y : 삭제 / N: 삭제 X',
    BOARD_FREE_PHOTO       VARCHAR(100),
    PRIMARY KEY (BOARD_FREE_ID)
    
);

--------------------- BOARD_FREE_COMMENT
CREATE TABLE BOARD_FREE_COMMENT (
    COMMENT_COMMENT_ID    SMALLINT     NOT NULL AUTO_INCREMENT,
    COMMENT_BOARD_FREE_ID INT          NOT NULL COMMENT '게시판 ID',
    COMMENT_USER_ID       VARCHAR(20)  NOT NULL COMMENT '유저 ID',
    COMMENT_CONTENT       VARCHAR(255) NOT NULL COMMENT '댓글 내용',
    COMMENT_RELEVEL       SMALLINT(6)  DEFAULT NULL COMMENT '댓글 계층',
    COMMENT_REGROUP       SMALLINT(6)  DEFAULT NULL COMMENT '댓글 그룹',
    COMMENT_RESTEP		  SMALLINT(6)  DEFAULT NULL COMMENT '댓글 순서',
    COMMENT_CREATED_AT    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '댓글 작성일',
    COMMENT_DELETE_YN     BOOLEAN      DEFAULT FALSE COMMENT '댓글 삭제여부 Y : 삭제 / N: 삭제 X',
    PRIMARY KEY (COMMENT_COMMENT_ID),
    CONSTRAINT fk_COMMENT_BOARD_FREE_ID FOREIGN KEY (COMMENT_BOARD_FREE_ID) REFERENCES BOARD_FREE (BOARD_FREE_ID)
);


-------------------- INQUIRY BOARD
CREATE TABLE BOARD_INQUIRY (
    BOARD_INQUIRY_ID  INT PRIMARY KEY COMMENT '1대1 게시판 아이디',
    BOARD_INQUIRY_BOARD_CRDT        TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '1대1 게시판 게시날짜', 
    BOARD_INQUIRY_BOARD_CRDT_MODIFY TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '1대1 게시판 게시날짜',
    -- INQUIRY_BOARD_WRITE_MEMBER_ID   INT COMMENT '실제 USER ID', -- 이 부분에설 실제 회원db와 외래키 적용예정.
    BOARD_INQUIRY_TITLE      VARCHAR(100) COMMENT '1대1 작성글 문의내용',
    BOARD_INQUIRY_CONTENT    VARCHAR(1000) COMMENT '1대1 게시판 작성내용',
    BOARD_INQUIRY_IS_PRIVATE BOOLEAN DEFAULT FALSE COMMENT '비밀글 여부'
);
---------------------------------- INQUIRY BOARD WRITE_ANSWER
CREATE TABLE BOARD_INQUIRY_ANSWER (
    BOARD_INQUIRY_ANSWER_ID         INT PRIMARY KEY COMMENT '일대일(답변) 아이디',
    BOARD_INQUIRY_ANSWER_CRDT       DATETIME COMMENT '답변 작성 날짜',
-- MEMBER_ID INT COMMENT '실제 USER ID', -- 이 부분에설 실제 회원db와 외래키 적용예정.
    BOARD_INQUIRY_ANSWER_INQUIRY_ID INT COMMENT '일대일 게시판 아이디', -- ONE_ON_ONE_INQUIRY_BOARD_WRITE의 외래키
    BOARD_INQUIRY_ANSWER_TITLE      VARCHAR(100) COMMENT '답변 제목',
    BOARD_INQUIRY_ANSWER_CONTENT    VARCHAR(1000) COMMENT '답변 내용',
    FOREIGN KEY (INQUIRY_BOARD_ANSWER_INQUIRY_ID) REFERENCES INQUIRY_BOARD_WRITE(INQUIRY_BOARD_INQUIRY_ID)
);

DROP TABLE IF EXISTS COMMENT;

DROP TABLE IF EXISTS BOARD_FREE;
DROP TABLE IF EXISTS INQUIRY_BOARD_WRITE;
DROP TABLE IF EXISTS INQUIRY_BOARD_WRITE_ANSWER;
--------------------- 


CREATE TABLE `BOARD_GAME_REVIEW` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '게시판 아이디',
  `WRITER_ID` varchar(50) NOT NULL COMMENT '게시판 작성자',
  `TITLE` varchar(50) NOT NULL COMMENT '게시판 제목',
  `CONTENT` varchar(255) NOT NULL COMMENT '게시판 내용',
  `VIEW_CNT` int(11) DEFAULT '0' COMMENT '게시판 조회수',
  `DELETE_YN` varchar(1) DEFAULT NULL COMMENT '게시판 삭제여부 Y:삭제 / N: 삭제X',
  `CREATE_DT` timestamp NOT NULL COMMENT '게시판 등록일자',
  `MODIFY_DT` timestamp NULL DEFAULT NULL COMMENT '게시판 수정일자',
  `DELETE_DT` timestamp NULL DEFAULT NULL COMMENT '게시판 삭제일자',
  PRIMARY KEY (`ID`)
);