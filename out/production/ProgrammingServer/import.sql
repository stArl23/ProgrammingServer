INSERT INTO user (id, username, password, mobilephone, email, description, avatar, nickname)
VALUES (1, 'knknkn', '123456', '13567394118', 'hlz321@qq.com', 'I am a boy', 'assets/images/shiba1.jpg', 'hhh');
INSERT INTO user (id, username, password, mobilephone, email, description, avatar, nickname)
VALUES (2, 'zxcc', '123456', '13567391111', 'aaa@qq.com', 'I am a girl', 'assets/images/shiba1.jpg', '666');

INSERT INTO category VALUES (1, 'python');
INSERT INTO category VALUES (2, 'javascript');
INSERT INTO category VALUES (3, 'blockly');

INSERT INTO program (id, avatar, author, title, image, content, rating, date)
VALUES (1, 'assets/images/user1.jpg', 'Mine7', '进制转换器', 'assets/images/program1.jpg', '多进制转换器v1.2测试版', 3.5, '2017-5-3');
INSERT INTO program (id, avatar, author, title, image, content, rating, date) VALUES
  (2, 'assets/images/user2.jpg', 'Susie', '魔方还原F2L测试', 'assets/images/program2.jpg',
   '先选择难度，然后点击上面的六个转法其中几个（简单的点击一个，中等点击两个，困难点击三个。）', 1.2, '2017,3,7');
INSERT INTO program (id, avatar, author, title, image, content, rating, date)
VALUES (3, 'assets/images/user1.jpg', 'Mine7', '画图放大程序', 'assets/images/program3.jpg', '神奇放大任意图案工具', 3.9, '2016-3-7');
INSERT INTO program (id, avatar, author, title, image, content, rating, date)
VALUES (4, 'assets/images/user3.jpg', '林恒', '摇红包', 'assets/images/program4.jpg', '摇红包功能正式开启！', 4.5, '2017-10-5');
INSERT INTO program (id, avatar, author, title, image, content, rating, date)
VALUES (5, 'assets/images/user4.jpg', '晚霞', '方块贪吃蛇', 'assets/images/program5.jpg', 'WASD移动。摁R重来。', 2.1, '2017-9-1');
INSERT INTO program (id, avatar, author, title, image, content, rating, date)
VALUES (6, 'assets/images/user5.jpg', '张船长', '炒股', 'assets/images/program6.jpg', '赚钱了', 4.56, '2017-1-1');


INSERT INTO message (id, user_id, title, content, date) VALUES (1, 1, '关注动态', 'xxx发布了一个新作品', now());
INSERT INTO message (id, user_id, title, content, date) VALUES (2, 1, '我的动态', '你的作品进制转换器被人收藏了', now());

INSERT INTO comment (id, program_id, user_id, date, rating, content)
VALUES (1, 1, 1, '2017,1,3', 2.1, 'daihhfoihfohfohoihfeh');
INSERT INTO comment (id, program_id, user_id, date, rating, content)
VALUES (2, 1, 2, '2017,4,1', 3.5, 'asdadadqqdcczzc');

INSERT INTO course (id, name, cover, content, rating) VALUES (1, 'Python', 'assets/images/python.jpg', 'Python基础', 2.3);
INSERT INTO course (id, name, cover, content, rating)
VALUES (2, 'JavaScript', 'assets/images/javascript.jpg', 'JavaScript基础', 4.2);
INSERT INTO course (id, name, cover, content, rating)
VALUES (3, 'Blockly', 'assets/images/blockly.jpg', 'Blockly基础', 4.6);


INSERT INTO chapter VALUES (1, '第一章', 1);
INSERT INTO chapter VALUES (2, '第二章', 1);
INSERT INTO chapter VALUES (3, '第一章', 2);
INSERT INTO chapter VALUES (4, '第一章', 3);

INSERT INTO class VALUES (1, '1-1', 1);
INSERT INTO class VALUES (2, '1-2', 1);
INSERT INTO class VALUES (3, '2-1', 2);
INSERT INTO class VALUES (4, '2-2', 2);
INSERT INTO class VALUES (5, '1-1', 3);
INSERT INTO class VALUES (6, '1-2', 3);
INSERT INTO class VALUES (7, '1-1', 4);
INSERT INTO class VALUES (8, '1-2', 4);


