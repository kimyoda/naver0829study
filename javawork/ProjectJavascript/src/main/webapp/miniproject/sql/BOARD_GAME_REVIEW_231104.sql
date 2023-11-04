-------------- CREATE TABLE
CREATE TABLE BOARD_GAME_REVIEW (
	ID 	 			INT 			AUTO_INCREMENT PRIMARY KEY 			COMMENT'게시판 아이디',
    WRITER_ID 		VARCHAR(50) 	NOT NULL							COMMENT'게시판 작성자',
	TITLE 		 	VARCHAR(50)		NOT NULL 							COMMENT'게시판 제목',
    CONTENT 	 	VARCHAR(255)	NOT NULL							COMMENT'게시판 내용',
    VIEW_CNT	 	INT				DEFAULT 0							COMMENT'게시판 조회수', 
	DELETE_YN		VARCHAR(1)											COMMENT'게시판 삭제여부 Y:삭제 / N: 삭제X',
    CREATE_DT 	 	TIMESTAMP		NOT NULL							COMMENT'게시판 등록일자',
	MODIFY_DT		TIMESTAMP											COMMENT'게시판 수정일자',
	DELETE_DT		TIMESTAMP											COMMENT'게시판 삭제일자'	
);