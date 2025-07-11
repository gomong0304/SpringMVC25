-- 시퀀스 객체 생성
create sequence seq_board;

-- 시퀀스 삭제(차후에 활용)
drop sequence seq_board;

-- 기본 board 테이블 생성
create table tbl_board(
	bno number(10,0),					-- 게시물 번호 (시퀀스 연결할꺼임)
	title varchar2(200) not null,		-- 제목
	content varchar2(2000) not null,	-- 내용
	writer varchar2(50) not null,		-- 작성자 (차후에 member와 연동)
	regdate date default sysdate,		-- 작성일 (자동으로 DB날짜가 입력)
	updatedate date default sysdate		-- 수정일 (자동으로 DB날짜가 입력)
);

-- tbl_board 구조변경(수정) 기본키를 bno로 지정함.
alter table tbl_board add constraint pk_board primary key (bno);

-- 더미데이터 입력하기
insert into TBL_BOARD (bno, title, content, writer) values (seq_board.nextval, '테스트제목1', '테스트 내용1', 'user00');
insert into TBL_BOARD (bno, title, content, writer) values (seq_board.nextval, '테스트제목2', '테스트 내용2', 'user00');
insert into TBL_BOARD (bno, title, content, writer) values (seq_board.nextval, '테스트제목3', '테스트 내용3', 'user00');
insert into TBL_BOARD (bno, title, content, writer) values (seq_board.nextval, '테스트제목4', '테스트 내용4', 'user00');
insert into TBL_BOARD (bno, title, content, writer) values (seq_board.nextval, '테스트제목5', '테스트 내용5', 'user00');
insert into TBL_BOARD (bno, title, content, writer) values (seq_board.nextval, '테스트제목6', '테스트 내용6', 'user00');
insert into TBL_BOARD (bno, title, content, writer) values (seq_board.nextval, '테스트제목7', '테스트 내용7', 'user00');
insert into TBL_BOARD (bno, title, content, writer) values (seq_board.nextval, '테스트제목8', '테스트 내용8', 'user00');

-- 한번에 보기
select * from tbl_board;