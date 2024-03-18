create database librarydb;
use librarydb;

-----------------------------------------------LIBRARIES---------------------------------------------------------
Create table libraries (
library_id int auto_increment primary key,
website char(100) ,
user_id int not null,
constraint fk_libraries_users foreign key (user_id) references users (user_id),
);

alter table libraries drop column registration_no;

-----------------------------------------------LIBRARIANS---------------------------------------------------------

Create table librarians (
librarian_id int auto_increment primary key,
adhaarcard char(12) not null unique,
about varchar(500),
library_id int not null,
constraint fk_librarians_libraries foreign key (library_id) references libraries (library_id),
qualification char(30) not null,
experience int not null,
user_id int not null,
constraint fk_librarians_users foreign key (user_id) references users (user_id)
);

ALTER TABLE librarians DROP COLUMN library_id;

---------------------------------------------CANDIDATES---------------------------------------------------------

create table candidates (
candidate_id int auto_increment primary key,
organization char(50),
user_id int not null,
constraint fk_candidates_users foreign key (user_id) references users (user_id),
dob date not null,
gender char(1) not null,
uid char(12) not null unique
);

---------------------------------------------USERS--------------------------------------------------------------

Create table users (
user_id int auto_increment primary key,
name char (50) not null,
email char (255) not null unique,
password char (255) not null,
phone char (10) not null unique,
pic char (255),
address varchar(500)  ,
city_id int not null,
constraint fk_users_cities foreign key (city_id) references cities (city_id),
otp char(6),
status_id int not null,
constraint fk_users_status foreign key (status_id) references status (status_id)
);

alter table users add column userType_id int not null,
add constraint fk_users_user_types foreign key (userType_id) references user_types (userType_id);
-------------------------------------------------MEMBERSHIP-TYPES----------------------------------------------------------------

Create table membership_Types (
membership_Type_id int auto_increment primary key,
type char (20) not null
);

insert into membership_Types (type) values ("General candidate"), ("Plus candidate");

--------------------------------------------------CITIES--------------------------------------------------------------

Create table cities (
city_id int auto_increment primary key,
name char(50) not null
);

insert into cities (name) values ('Jabalpur'),('Bhopal'),('Indore'),('Pune'),('Chandighar'),('Jaipur'),('Others')
-------------------------------------------------STATUS--------------------------------------------------------------

Create table status (
status_id int auto_increment primary key,
type char(20) not null
);

insert into status (name) values ('Active'),('Inactive'),('Closed'),('Blocked'),('Pending');

-------------------------------------------------PUBLISHERS---------------------------------------------------------------

Create table publishers (
publisher_id int auto_increment primary key,
website char(100) not null,
user_id int not null,
constraint fk_publishers_users foreign key (user_id) references users (user_id),
registration_no char(50) not null unique
);

-----------------------------------------------------BOOKS---------------------------------------------------------

Create table books (
book_id int auto_increment primary key,
name char(80) not null,
about varchar(1000) not null,
category_id int not null,
constraint fk_books_categories foreign key (category_id) references categories (category_id),
publisher_id int not null,
constraint fk_books_publishers foreign key (publisher_id) references publishers (publisher_id)
);

-- publisher_id delete 
 ALTER TABLE editions MODIFY COLUMN date DATE;

---------------------------------------------------EDITIONS-------------------------------------------------------------

Create table editions (
edition_id int auto_increment primary key,
book_id int not null,
constraint fk_issuedbook_books foreign key (book_id) references books (book_id),
editions char(5) not null,
price int not null,
ISBN char(20) not null,
years int not null,
weights float not null,
pages int not null
);

------------------------------------------------LIBRARY-BOOKS-----------------------------------------------------------------

Create table library_Books(
libraryBook_id int auto_increment primary key,
library_id int not null,
constraint fk_library_Books_libraries foreign key (library_id) references libraries (library_id),
edition_id int not null,
constraint fk_library_Books_editions foreign key (edition_id) references editions (edition_id),
copies int not null
);

-------------------------------------------------CATEGORIES------------------------------------------------------------

Create table categories (
category_id int auto_increment primary key,
type char(20) not null
);

insert into categories (type) values ('Horror'),('Mystery'),('Biography'),('Poetry'),('Science Fiction'),('History'),('Maths'),('Technical'),('SSC'),('Bank');

---------------------------------------------------MEMBERSHIPS--------------------------------------------------------------

Create table memberships(
membership_id int auto_increment primary key,
library_id int not null,
constraint fk_memberships_libraries foreign key (library_id) references libraries (library_id),
candidate_id int not null,
constraint fk_memberships_candidates foreign key (candidate_id) references candidates (candidate_id),
date_of_join date not null,
membership_Type_id int not null,
constraint fk_memberships_membership_Types foreign key (membership_Type_id) references membership_Types (membership_Type_id),
status_id int not null,
constraint fk_memberships_status foreign key (status_id) references status (status_id),
deposit int not null
);

----------------------------------------------ISSUED-BOOKS-------------------------------------------------------------------


Create table issued_Books (
issued_book_id int auto_increment primary key,
membership_id int not null,
constraint fk_issuedBooks_memberships foreign key (membership_id) references memberships (membership_id),
issued_on date not null,
expected_return_date date not null,
actual_return_date date,
fine int not null DEFAULT 0,
libraryBook_id int not null,
constraint fk_issued_Books_library_Books foreign key (libraryBook_id) references library_Books (libraryBook_id)
);


-----------------------------------------------USER-TYPES------------------------------------------------------------------
Create table user_Types(
userType_id int auto_increment not null primary key,
name char(20) not null
);

insert into user_Types (name) values ('Library'),('Librarian'),('Candidate'),('Publisher');


-- select user_id,u.name,email,password,phone,pic,address,c.city_id,c.name,s.status_id,t.userType_id 
-- from users as u inner join cities as c
-- inner join status as s inner join user_Types as t where u.city_id = c.city_id and u.status_id = s.status_id and
-- u.userType_id = t.userType_id 
-- and email="priyavish22184@gmail.com";

