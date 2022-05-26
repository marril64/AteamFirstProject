create table reuser (
	userNum int primary key auto_increment,
    id varchar(10) not null,
    pw varchar(10) not null,
    phone varchar(15) not null,
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
	storeNum int primary key auto_increment,
    storeName varchar(10) not null,
	storeTime varchar(30) not null,
    storeAdd varchar(50) not null,
    storePhone varchar(15) not null,
    menu varchar(20) not null,
    storeContent varchar(500) not null,
    storeHit int default 0
);

CREATE TABLE bookMark (
    bookNum INT AUTO_INCREMENT PRIMARY KEY,
    storeNum int not null,
    userNum int not null,
    FOREIGN KEY(storeNum) REFERENCES storeinfo(storeNum),
    FOREIGN KEY(userNum) REFERENCES reuser(userNum)
);

insert into reuser (id, pw, phone, nick) values ("marril64", "1111", 01099668908, "자바크릭");
insert into reuser (id, pw, phone, nick) values ("Admin", "1111", 01012345678, "관리자");

insert into reviewr values("1","1","이집 최고","신촌왕자","0",now(),"신촌에 파스타 집중에 최고로 맛있어요 특히 크림파스타가 맛있습니다.","5");
insert into reviewr values("2","1","최고","신촌z","0",now(),"크림파스타가 맛있습니다.","5");
insert into reviewr values("3","1","추천","신촌w","0",now(),"음식은 맛있었어요.","4");

insert into storeinfo values (null, "신촌곱창", "16:00 ~ 03:00", "서울특별시 서대문구 창천동 33-460", 023454445 , "곱창/대창", "돌판 위에 구워져 나오는 곱창구이 전문점. 메뉴로 소곱창, 소대창, 소막창, 곱창모듬구이, 간과 천엽, 염통 등이 있으며 곱창 주문 시 곱창과 함께 떡, 감자, 양파, 양배추, 파 채가 함께 나오며 마 가루를 뿌려줌", null);
insert into storeinfo values (null, "홍대개미", "11:30 ~ 22:00", "서울특별시 마포구 상수동 317-3", 025869289 , "일식덮밥", "신선한 재료를 엄선하고, 하나하나 손질하여 정성을 듬뿍 담아 요리합니다. 이곳의 메뉴는 스테이크 덮밥, 연어덮밥, 참치 덮밥 등의 메뉴가 있습니다. 저렴한 가격에 푸짐한 소고기를 즐길 수 있는 스테이크 덮밥, 연어덮밥, 신선한 회로 만드는 참치 덮밥 모든 메뉴에는 미니우동이 추가로 제공", null);
insert into storeinfo values (null, "이치류", "17:00 ~ 23:00", "서울특별시 마포구 서교동 395-124", 025869289 , "일식", "양고기를 처음 접하는 이들도 부담 없이 방문할 수 있으며, 숙련된 직원들이 고기를 직접 구워주기 때문에 편한 식사가 가능합니다. 이치류의 양고기는 소고기와 같이 바싹 익히지 않은 상태로 이곳의 특제소스에 찍어 먹으면 더욱 맛있게 즐길 수 있습니다", null);
insert into storeinfo values (null, "신촌수제비", "10:00 ~ 21:00", "서울특별시 서대문구 창천동 30-10", 023349252 , "분식/김밥", "신촌수제비’는 30년째 운영 중인 수제비 전문점으로 저렴한 가격에 푸짐하게 식사를 즐길 수 있는 곳입니다. 대표 메뉴는 진한 사골 육수로 끓여낸 ‘수제비’입니다. 수북하게 담은 수제비 위로 볶은 호박과 당근을 고명으로 올려냅니다", null);
insert into storeinfo values (null, "오늘통닭 ", "17:00 ~ 00:00 ", "서울특별시 서대문구 창천동 33-34", 0231440692 , "치킨/통닭", "1977년에 오픈한 통닭 전문점 삼성통닭이 상호를 변경하여새로태어났습니다. SBS 해결 돈이보인다에 방영됬을정도로,작은각에서 시작하였지만 성공을 거둔곳인데요 양념통닭은 튀김옷속에도 양념이 배어있는것이 특징", null);
insert into storeinfo values (null, "고삼이", "11:00 ~ 22:00", "서울특별시 서대문구 창천동 53-8", 023241403 , "생선구이/생선요리", "고등어 구이가 인기인 생선구이 전문점 고삼이의 신촌 본점입니다. 입구에 들어서는 순간 사람 키 높이의 생선 굽는 오븐이 눈을 사로잡는데요. 실내 빼곡히 붙은 사진들에서도 알 수 있듯 인근 대학생들이 주 손님으로, 구이류 중에서는 고등어구이와 삼치구이가, 다른 메뉴 중에서는 김치찌개와 돼지불백이 가장 인기입니다", null);