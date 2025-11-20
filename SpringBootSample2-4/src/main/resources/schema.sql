CREATE TABLE IF NOT EXISTS employee(
id VARCHAR(50) PRIMARY KEy,
name VARCHAR(50), 
age INT
); 

/* ユーザーマスタ */
/* m_userテーブルを作成する（user_idをキー項目とする */
CREATE TABLE IF NOT EXISTS m_user(
   user_id VARCHAR(50) PRIMARY KEY
 , password VARCHAR(100)
 , user_name VARCHAR(50)
 , birthday DATE
 , age INT
 , gender INT
 , department_id INT
 , role VARCHAR(50)
);

/* 部署マスタ */
/* m_departmentテーブルを作成する（departmentをキー項目とする） */
CREATE TABLE IF NOT EXISTS m_department (
   department_id INT PRIMARY KEY
 , department_name VARCHAR(50)
);

/* 給料テーブル */
/* salaryテーブルを作成する（user_idとyear_monthをキー項目とする）*/
CREATE TABLE IF NOT EXISTS t_salary (
   user_id VARCHAR(50)
 , year_month VARCHAR(50)
 , salary INT
 , PRIMARY KEY(user_id, year_month)
);
