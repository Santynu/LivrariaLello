CREATE DATABASE livraria_lello;
USE livraria_lello;

CREATE TABLE `authors` (
   id int AUTO_INCREMENT,
   name varchar(60),
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `publishing_houses` (
     id int AUTO_INCREMENT,
     name varchar(40),
     PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `books` (
    `isbn_13` varchar(13) NOT NULL,
    `isbn_10` varchar(10) NOT NULL,
    `title` varchar(80) DEFAULT NULL,
    `author_id` int,
    `publishing_house_id` int,
    PRIMARY KEY (`isbn_13`),
    FOREIGN KEY (author_id) REFERENCES authors(id),
    FOREIGN KEY (publishing_house_id) REFERENCES publishing_houses(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO publishing_houses (name) VALUES
    ("Scholastic Press"),
    ("Arthur A. Levine Books"),
    ("Bloomsbury Publishing");

INSERT INTO authors (name) VALUE ("J.K. Rowling");


INSERT INTO books (isbn_13, isbn_10, title, author_id, publishing_house_id) VALUES
    ("9780590353403", "0590353403", "Harry Potter and the Philosopher's Stone", 1, 1),
    ("9780439064866", "0439064864", "Harry Potter and the Chamber of Secrets", 1, 1),
    ("9780439136358", "0439136350", "Harry Potter and the Prisoner of Azkaban", 1, 1),
    ("9780439139595", "0439139597", "Harry Potter and the Goblet of Fire", 1, 1),
    ("9780439358064", "1781100241", "Harry Potter and the Order of the Phoenix", 1, 2),
    ("9788175994348", "8175994347", "Harry Potter and the Half-Blood Prince", 1, 3),
    ("9781408855959", "140885595X", "Harry Potter & The Deathly Hallows", 1, 2);

commit;