CREATE DATABASE livraria_lello;
USE livraria_lello;

CREATE TABLE `books` (
    `isbn_13` varchar(13) NOT NULL,
    `isbn_10` varchar(10) NOT NULL,
    `title` varchar(80) DEFAULT NULL,
    `author` varchar(60) DEFAULT NULL,
    `editorial` varchar(40) DEFAULT NULL,
    PRIMARY KEY (`isbn_13`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO books (isbn_13, isbn_10, title, author, editorial) VALUES
    ("9780590353403", "0590353403", "Harry Potter and the Philosopher's Stone", "J.K. Rowling", "Scholastic Press"),
    ("9780439064866", "0439064864", "Harry Potter and the Chamber of Secrets", "J.K. Rowling", "Scholastic Press"),
    ("9780439136358", "0439136350", "Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", "Scholastic Press"),
    ("9780439139595", "0439139597", "Harry Potter and the Goblet of Fire", "J.K. Rowling", "Scholastic Press"),
    ("9780439358064", "1781100241", "Harry Potter and the Order of the Phoenix", "J.K. Rowling", "Arthur A. Levine Books"),
    ("9788175994348", "8175994347", "Harry Potter and the Half-Blood Prince", "J.K. Rowling", "Bloomsbury Publishing"),
    ("9781408855959", "140885595X", "Harry Potter & The Deathly Hallows", "J.K. Rowling", "Arthur A. Levine Books");

commit;