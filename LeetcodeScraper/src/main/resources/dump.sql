CREATE DATABASE leetcode_db;
SELECT leecode_db;
CREATE TABLE questions(
pk_question_id INT NOT NULL AUTO_INCREMENT,
question_name VARCHAR(100),
question_link VARCHAR(250),
solution_link VARCHAR(300),
difficulty VARCHAR(10),
PRIMARY KEY(pk_question_id)
);
CREATE TABLE companies(
pk_company_id INT NOT NULL AUTO_INCREMENT,
company_name VARCHAR(100),
PRIMARY KEY(pk_company_id)
);
CREATE TABLE tags(
pk_tag_id INT NOT NULL AUTO_INCREMENT,
tag_name VARCHAR(100),
PRIMARY KEY(pk_tag_id)
);
CREATE TABLE companies_mapping(
pk_company_mapping_id INT NOT NULL AUTO_INCREMENT,
fk_company_id INT,
fk_question_id INT,
PRIMARY KEY(pk_company_mapping_id),
FOREIGN KEY(fk_company_id) REFERENCES companies(pk_company_id),
FOREIGN KEY(fk_question_id) REFERENCES questions(pk_question_id)
);
CREATE TABLE tags_mapping(
pk_tag_mapping_id INT NOT NULL AUTO_INCREMENT,
fk_tag_id INT,
fk_question_id INT,
PRIMARY KEY(pk_tag_mapping_id),
FOREIGN KEY(fk_tag_id) REFERENCES tags(pk_tag_id),
FOREIGN KEY(fk_question_id) REFERENCES questions(pk_question_id)
);