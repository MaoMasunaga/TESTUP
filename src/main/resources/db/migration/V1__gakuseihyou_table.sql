CREATE TABLE gakuseihyou (
    id SERIAL NOT NULL,
    studentnumber VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学生番号',
    name VARCHAR(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名前',
    age VARCHAR(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '年齢',
    mail VARCHAR(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'メールアドレス',
    phone VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '電話番号',
    password VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci Not NUll COMMENT 'パスワード',
    PRIMARY KEY (studentnumber)
) ENGINE=InnoDB;