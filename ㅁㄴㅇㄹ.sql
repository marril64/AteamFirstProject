CREATE TABLE boardTbl(
	board_num int AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    content VARCHAR(2000) NOT NULL,
    writer VARCHAR(30) NOT NULL,
    bdate datetime default now(),
    mdate datetime default now(),
    hit int default 0
);
DROP TABLE boardTbl;
-- 글 2개만 INSERT INTO로 적어주세요.
INSERT INTO boardTbl (title, content, writest1ter) VALUES ("가슴이 웅장해진다", "미안 나도 어그로 끌어봤다", "신다하");
INSERT INTO boardTbl VALUES (null, "대충 타이틀", "대충 글내용", "신동호", now(), now(), 0);







select * from test1;


