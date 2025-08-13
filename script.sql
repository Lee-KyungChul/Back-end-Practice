

CREATE TABLE tbl_reel (
    reel_no INT NOT NULL,
    fishing_point VARCHAR(50) NOT NULL,
    fishing_type VARCHAR(50) NOT NULL,
    reel_name VARCHAR(50) NOT NULL,
    reel_type VARCHAR(50) NOT NULL,
    reel_weight VARCHAR(10) NOT NULL, 
    PRIMARY KEY (reel_no)
);
INSERT INTO tbl_reel (reel_no, fishing_point, fishing_type, reel_name, reel_type, reel_weight) VALUES
(1, '계류', '플라이', 'Abel Tr #1', '플라이', '소'),
(2, '계류', '플라이', 'SAGE Click #3', '플라이', '중'),
(3, '강', '플라이', 'LOOP Opti #4', '플라이', '소'),
(4, '강', '플라이', 'Hardy LRH #5', '플라이', '중'),
(5, '강', '플라이', 'HARDY MARQUS #8', '플라이', '대'),
(6, '강', '루어', 'Daiwa can', '스피닝', '소'),
(7, '강', '루어', 'Shimano steer', '스피닝', '중'),
(8, '강', '루어', 'Shimano stone', '스피닝', '대'),
(9, '선상', '선상', 'Shimano light', '베이트', '소'),
(10, '선상', '선상', 'Daiwa 은콩 ', '베이트', '중'),
(11, '선상', '선상', 'Daiwa 금콩 ', '베이트', '대'),
(12, '방파제', '방파제', 'Simano Long', '스피닝', '소'),
(13, '방파제', '방파제', 'Daiwa can', '스피닝', '중'),
(14, '방파제', '원투', 'Simano light', '스피닝', '소'),
(15, '방파제', '원투', 'Simano Hang', '스피닝', '중'),
(16, '방파제', '원투', 'Daiwa cong', '스피닝', '대'),
(17, '방파제', '루어', 'Simano Long', '스피닝', '소'),
(18, '방파제', '루어', 'Daiwa can', '스피닝', '중'),
(19, '방파제', '루어', 'Simano Hang', '스피닝', '대'),
(20, '갯바위', '갯바위', 'Shimano steer', '스피닝', '소'),
(21, '갯바위', '갯바위', 'Daiwa can', '스피닝', '중'),
(22, '갯바위', '갯바위', 'Shimano steer', '스피닝', '대'),
(23, '갯바위', '루어', 'Shimano steer', '스피닝', '소'),
(24, '갯바위', '루어', 'Daiwa can', '스피닝', '중'),
(25, '갯바위', '루어', 'Shimano steer', '스피닝', '대'),
(26, '갯바위', '원투', 'Shimano steer', '스피닝', '소'),
(27, '갯바위', '원투', 'Daiwa can', '스피닝', '중'),
(28, '갯바위', '원투', 'Shimano steer', '스피닝', '대');


CREATE TABLE tbl_rod (
    rod_no INT NOT NULL,
    fishing_point VARCHAR(20) NOT NULL,
    rod_type VARCHAR(20) NOT NULL,
    rod_name VARCHAR(20) NOT NULL,
    rod_length VARCHAR(5),
    rod_action VARCHAR(20),
    fish_size VARCHAR(5),
    PRIMARY KEY (rod_no)
);
INSERT INTO tbl_rod (rod_no, fishing_point, rod_type, rod_name, rod_length, rod_action, fish_size) VALUES
(1, '계류', '플라이', 'SAGE SLP #0', '7.0', '울트라라이트', '소'),
(3, '계류', '플라이', 'Thomas LPS #2', '7.6', '라이트', '중'),
(4, '계류', '플라이', 'Thomas LPS #3', '8.0', '라이트', '대'),
(5, '계류', '루어', 'Daiwa zoshs', '7.2','울트라라이트', '소'),
(6, '계류', '루어', 'Daiwa fcds', '7.6', '라이트', '중'),
(7, '계류', '루어', 'Daiwa rw33', '8.0', '미디엄', '대'),
(8, '강', '플라이', 'Winston pure #3', '8.3', '라이트', '소'),
(9, '강', '플라이', 'Scott GS #4', '9.0', '미디엄', '중'),
(10, '강', '플라이', 'Hardy marksman #6', '9.0', '페스트', '대'),
(11, '강', '플라이', 'Hardy marksman #8', '14.0', '페스트', '특대'),
(12, '강', '루어', 'Daiwa 루키', '6.2', '라이트', '소'),
(13, '강', '루어', 'Shimno 딥블루', '6.8', '미디엄', '중'),
(14, '강', '루어', 'Shimno 딥레드', '8.8', '미디엄', '대'),
(15, '선상', '선상', 'NS 헤리케인', '5.2', '울트라라이트', '소'),
(16, '선상', '선상' , 'JS 참에어베타2', '6.2', '미디엄', '중'),
(17, '선상', '선상' , 'JS 참에어베타 3', '7.2', '미디엄', '대'),
(18, '방파제', '루어', 'JS 라이트캐스트', '6.0', '울트라라이트', '소'),
(19, '방파제', '루어', 'JS 라이트캐스트', '8.0', '라이트', '중'),
(20, '방파제', '루어', 'JS 라이트캐스트', '9.0', '미디엄', '대'),
(21, '방파제', '원투', 'NS 레이크마스터 short', '12.0', '미디엄', '소'),
(22, '방파제', '원투', 'NS 레이크마스터 normal', '14.0', '미디엄', '중'),
(23, '방파제', '원투', 'NS 레이크마스터 long', '16.0', '미디엄', '대'),
(24, '저수지', '민물', '은성 루키 1', '9.0', '라이트', '소'),
(25, '저수지', '민물', '은성 루키 2', '12.0', '미디엄', '중'),
(26, '저수지', '민물', '은성 루키 3', '14.0', '헤비', '대'),
(27, '갯바위', '갯바위', '다이와 스타', '6.0', '라이트', '소'),
(28, '갯바위', '갯바위', '다이와 스타', '9.0', '라이트', '중'),
(29, '갯바위', '갯바위', '시마노 dfsd', '11.0', '라이트', '대');



CREATE TABLE tbl_fish (
    fish_no INT NOT NULL,
    fish_name VARCHAR(20) NOT NULL,
    fishing_type VARCHAR(20) NOT NULL,
    fishing_point VARCHAR(20) NOT NULL,
    fish_size VARCHAR(2) NOT NULL
);

INSERT INTO tbl_fish (fish_no, fish_name, fishing_type, fishing_point, fish_size) VALUES
(1, '송어', '플라이', '강', '소'),
(2, '송어', '플라이', '강', '중'),
(3, '송어', '플라이', '강', '대'),
(4, '송어', '플라이', '계류', '소'),
(5, '송어', '플라이', '계류', '중'),
(6, '송어', '플라이', '계류', '대'),
(7, '송어', '루어', '강', '소'),
(8, '송어', '루어', '강', '중'),
(9, '송어', '루어', '강', '대'),
(10, '송어', '루어', '계류', '소'),
(11, '송어', '루어', '계류', '중'),
(12, '송어', '루어', '계류', '대'),
(13, '배스', '루어', '계류', '소'),
(14, '배스', '루어', '계류', '중'),
(15, '배스', '루어', '저수지', '소'),
(16, '배스', '루어', '저수지', '중'),
(17, '배스', '루어', '저수지', '대'),
(18, '배스', '루어', '강', '소'),
(19, '배스', '루어', '강', '중'),
(20, '배스', '루어', '강', '대'),
(21, '고등어', '루어', '방파제', '소'),
(22, '고등어', '루어', '방파제', '중'),
(23, '고등어', '선상', '선상', '소'),
(24, '고등어', '선상', '선상', '소'),
(25, '고등어', '선상', '선상', '대'),
(26, '참돔', '선상', '선상', '소'),
(27, '참돔', '선상', '선상', '중'),
(28, '참돔', '선상', '선상', '대'),
(29, '참돔', '갯바위', '갯바위', '소'),
(30, '참돔', '갯바위', '갯바위', '중'),
(31, '참돔', '갯바위', '갯바위', '대'),
(32, '쭈꾸미', '선상', '선상', '소'),
(33, '광어', '원투', '방파제', '소'),
(34, '광어', '원투', '방파제', '중'),
(35, '광어', '원투', '방파제', '대'),
(36, '광어', '선상', '선상', '소'),
(37, '광어', '선상', '선상', '중'),
(38, '광어', '선상', '선상', '대'),
(39, '연어', '플라이', '강', '특대'),
(40, '연어', '플라이', '강', '대'),
(41, '연어', '플라이', '강', '중'),
(42, '쏘가리', '루어', '강', '소'),
(43, '쏘가리', '루어', '강', '중'),
(44, '쏘가리', '루어', '강', '대'),
(45, '쏘가리', '루어', '계류', '소'),
(46, '쏘가리', '루어', '계류', '중'),
(47, '우럭', '루어', '방파제', '소'),
(48, '우럭', '루어', '방파제', '중'),
(49, '우럭', '루어', '방파제', '대'),
(50, '우럭', '갯바위, '갯바위', '소'),
(51, '우럭', '갯바위', '갯바위', '중'),
(52, '우럭', '갯바위', '갯바위', '대'),
(53, '우럭', '선상', '선상', '소'),
(54, '우럭', '선상', '선상', '중'),
(55, '우럭', '선상', '선상', '대'),
(56, '산천어', '플라이', '계류', '소'),
(57, '산천어', '플라이', '계류', '중'),
(58, '산천어', '플라이', '계류', '대'),
(59, '산천어', '루어', '계류', '소'),
(60, '산천어', '루어', '계류', '중'),
(61, '산천어', '루어', '계류', '대');







*로드 선택
select A.fish_name, A.fishing_point, A.fishing_type, A.fish_size, B.rod_name, B.rod_type, rod_length, B.rod_action from
(select fish_name, fishing_point, fishing_type, fish_size
from tbl_fish
where fish_name = "광어") as A
join tbl_rod B
on A.fishing_point = B.fishing_point
AND A.fish_size = B.fish_size
WHERE A.fishing_point = "선상" AND B.rod_type = "선상" AND B.fish_size = "소";




*릴 선택
select A.fish_name, A.fishing_point, A.fishing_type, A.fish_size, B.reel_name, B.reel_type, reel_weight from
(select fish_name, fishing_point, fishing_type, fish_size
from tbl_fish
where fish_name = "송어") as A
join tbl_reel B
on A.fishing_point = B.fishing_point
AND A.fish_size = B.reel_weight
AND A.fishing_type = B.reel_type
WHERE B.fishing_point = "계류" AND B.reel_weight = "소";




select
C.fish_name,C.fishing_point, C.fishing_type, C.fish_size, C.reel_name, C.reel_type, C.reel_weight,
D.rod_name, D.rod_type, D.rod_length, D.rod_action from 
(select A.fish_name, A.fishing_point, A.fishing_type, A.fish_size, B.reel_name, B.reel_type, reel_weight from
(select fish_name, fishing_point, fishing_type, fish_size
from tbl_fish
where fish_name = "광어") as A
join tbl_reel B
on A.fishing_type = B.fishing_type
AND A.fishing_point = B.fishing_point) as C
join tbl_rod D
on C.fishing_type = D.rod_type
AND C.fishing_point = D.fishing_point
AND C.fish_size = D.fish_size
Where C.fishing_point ="선상";



