create table reuser (
	userNum int primary key auto_increment,
    id varchar(10) not null,
    pw varchar(10) not null,
    phone int not null,
    nick varchar(10) not null,
    bookmark varchar(8)
);

create table reviewr (
	reviewNum int auto_increment primary key,
	boardNum int not null,
	reviewName varchar(15) not null,
	ruser varchar(10) not null,
	rhit int default 0,
	reviewDate datetime default now(),
	reviewcontent varchar(300) not null,
	score int not null
);

create table storeinfo (
	stroeNum int primary key auto_increment,
    storeName varchar(10) not null,
	storeTime varchar(20) not null,
    storeAdd varchar(50) not null,
    storePhone int not null,
    menu varchar(20) not null,
    storeContent varchar(500) not null
);

insert into reuser (id, pw, phone, nick) values ("marril64", "1111", 01099668908, "자바크릭");
insert into reuser (id, pw, phone, nick) values ("ril", "2222", 01012345678, "박자바");
insert into reuser (id, pw, phone, nick) values ("mar", "3333", 01098765432, "김스프링");

insert into reviewr values("1","1","이집 최고","신촌왕자","0",now(),"신촌에 파스타 집중에 최고로 맛있어요 특히 크림파스타가 맛있습니다.","5");
insert into reviewr values("2","1","최고","신촌z","0",now(),"크림파스타가 맛있습니다.","5");
insert into reviewr values("3","1","추천","신촌w","0",now(),"음식은 맛있었어요.","4");

insert into storeinfo () values ();
insert into storeinfo () values ();
insert into storeinfo () values ();