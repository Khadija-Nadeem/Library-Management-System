CREATE DATABASE Library_Management_System;
USE Library_Management_System;

CREATE TABLE users( 
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
name VARCHAR(50) NOT NULL,
password VARCHAR(50) NOT NULL,
email VARCHAR(100) NOT NULL,
contact VARCHAR(20) NOT NULL);
SELECT * FROM users;

CREATE TABLE book_details( 
book_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
book_name VARCHAR(250) NOT NULL,
author VARCHAR(100) NOT NULL,
quantity INT NOT NULL);
INSERT INTO book_details (book_id, book_name, author, quantity) VALUES
-- Study
(1, 'Introduction to Algorithms', 'Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, and Clifford Stein', 4),
(2, 'Artificial Intelligence: A Modern Approach', 'Stuart Russell and Peter Norvig', 3),
-- Novel
(3, 'To Kill a Mockingbird', 'Harper Lee', 5),
(4, '1984', 'George Orwell', 3),
-- History
(5, 'Guns, Germs, and Steel: The Fates of Human Societies', 'Jared Diamond', 4),
(6, 'A People''s History of the United States', 'Howard Zinn', 5),
-- Fiction
(7, 'The Da Vinci Code', 'Dan Brown', 4),
(8, 'The Shining', 'Stephen King', 3),
-- Non-Fiction
(9, 'Sapiens: A Brief History of Humankind', 'Yuval Noah Harari', 6),
(10, 'Educated', 'Tara Westover', 4),
-- General Knowledge (GK)
(11, 'A Short History of Nearly Everything', 'Bill Bryson', 4),
(12, 'The World Atlas of Wine', 'Hugh Johnson and Jancis Robinson', 3);
SELECT * FROM book_details;

CREATE TABLE student_details( 
student_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
student_name VARCHAR(100) NOT NULL,
program VARCHAR(100) NOT NULL,
department VARCHAR(100) NOT NULL);
INSERT INTO student_details (student_id, student_name, program, department) VALUES
-- Students in B.Arch Program
(1, 'Ali Khan', 'B.Arch', 'Architecture and Planning'),
(2, 'Sara Ahmed', 'B.Arch', 'Architecture and Planning'),
-- Students in B.E Program
(3, 'Omar Farooq', 'B.E', 'Civil Engineering'),
(4, 'Aisha Iqbal', 'B.E', 'Mechanical Engineering'),
(5, 'Fatima Tariq', 'B.E', 'Chemical Engineering'),
(6, 'Hassan Malik', 'B.E', 'Electrical Engineering'),
-- Students in B.S Program
(7, 'Mariam Yousaf', 'B.S', 'Computer Science'),
(8, 'Ahmed Raza', 'B.S', 'Artificial Intelligence'),
(9, 'Nadia Hussain', 'B.S', 'Cyber Security'),
(10, 'Zainab Sheikh', 'B.S', 'Electronic Engineering');
SELECT * FROM student_details;

CREATE TABLE issue_book_details( 
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
book_id INT,
book_name VARCHAR(100) NOT NULL,
student_id INT,
student_name VARCHAR(100) NOT NULL,
checkout_date DATE,
return_deadline_date DATE,
status VARCHAR(150));
INSERT INTO issue_book_details (id, book_id, book_name, student_id, student_name, checkout_date, return_deadline_date, status) VALUES
(1, 2, 'Artificial Intelligence: A Modern Approach', 6, 'Hassan Malik', '2024-07-10', '2024-07-25', 'Pending'), -- Defaulter
(2, 5, 'Guns, Germs, and Steel: The Fates of Human Societies', 1, 'Ali Khan', '2024-07-05', '2024-07-15', 'Returned'),
(3, 3, 'To Kill a Mockingbird', 4, 'Aisha Iqbal', '2024-06-20', '2024-07-10', 'Pending'), -- Defaulter
(4, 7, 'The Da Vinci Code', 2, 'Sara Ahmed', '2024-07-01', '2024-07-20', 'Returned'),
(5, 1, 'Introduction to Algorithms', 7, 'Mariam Yousaf', '2024-07-18', '2024-08-01', 'Pending'),
(6, 8, 'The Shining', 3, 'Omar Farooq', '2024-07-12', '2024-07-22', 'Pending'), -- Defaulter
(7, 9, 'Sapiens: A Brief History of Humankind', 5, 'Fatima Tariq', '2024-07-20', '2024-08-05', 'Pending'),
(8, 10, 'Educated', 2, 'Sara Ahmed', '2024-07-01', '2024-07-28', 'Pending'), -- Defaulter
(9, 4, '1984', 7, 'Mariam Yousaf', '2024-07-10', '2024-07-27', 'Returned'),
(10, 6, 'A People''s History of the United States', 4, 'Aisha Iqbal', '2024-07-25', '2024-08-10', 'Pending');
SELECT * FROM issue_book_details;
