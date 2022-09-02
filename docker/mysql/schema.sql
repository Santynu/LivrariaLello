CREATE DATABASE livraria_lello;
USE livraria_lello;

CREATE TABLE `books` (
    `isbn` int(10) NOT NULL,
    `title` int(80) DEFAULT NULL,
    `author` varchar(60) DEFAULT NULL,
    `editorial` varchar(40) DEFAULT NULL,
    PRIMARY KEY (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;