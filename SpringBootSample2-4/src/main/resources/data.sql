INSERT INTO employee (id, name, age) 
VALUES('1', 'Tom', 30);

/* ユーザーマスタ */
/* m_userテーブルにデータを2件追加する。 */
INSERT INTO m_user(
   user_id
 , password
 , user_name
 , birthday
 , age
 , gender
 , department_id
 , role
) VALUES
('system@co.jp', '$2a$10$rJyapIrvsHARwCNgporWLO6QIKXXezOpRrdb..7X0ea0VwZ5IldSy', 'システム管理者', '2000-01-01', 21, 1, 1, 'ROLE_ADMIN') 
, ('user@co.jp', '$2a$10$rJyapIrvsHARwCNgporWLO6QIKXXezOpRrdb..7X0ea0VwZ5IldSy', 'ユーザー1', '2000-01-01', 21, 2, 2, 'ROLE_GENERAL')
;

/* 部署マスタ */
/* m_departmentテーブルにデータを2件追加する。 */
INSERT INTO m_department (
   department_id
 , department_name
) VALUES
(1, 'システム管理部')
,(2,'営業部')
;

/* 給料テーブル */
/* t_salaryテーブルにデータを3件追加する。
（キー項目がuser_idとyear_monthでありuser_idが重複しているがyear_monthが重複していないため問題なし） */
INSERT INTO t_salary (
   user_id
 , year_month
 , salary
) VALUES
('user@co.jp', '2020/11', 280000)
,('user@co.jp', '2020/12', 290000)
,('user@co.jp', '2021/01', 300000)
;
