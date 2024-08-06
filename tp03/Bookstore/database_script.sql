CREATE DATABASE Bookstore;
USE Bookstore;
 
CREATE TABLE `books` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `title` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `price` float NOT NULL
);

SELECT * FROM books;