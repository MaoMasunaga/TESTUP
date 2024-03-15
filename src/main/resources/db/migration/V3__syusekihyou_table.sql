CREATE TABLE syusekihyou (
    id SERIAL NOT NULL COMMENT 'ID',
    studentnumber VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学生番号',
    syuketu VARCHAR(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '出欠確認',
    syuseki DATETIME NOT NULL COMMENT '出席時刻',
    PRIMARY KEY (studentnumber)
) ENGINE=InnoDB;