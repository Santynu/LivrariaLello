<!DOCTYPE html>
<html lang="Project of a basic CRUD library">
<head>
    <link rel="stylesheet" href="../main-styles.css">
    <link rel="icon" href="/assets/images/deathly_hallows_sign_black.svg" type="image/x-icon">
    <title>Livraria Lello</title>
    <script src="../bundle-index.js"></script>
</head>
<body>
    <nav>
        <div class="content">
            <img src="/assets/images/deathly_hallows_sign_white.svg" alt="deathly_hallows_sign">
            <span>Livraria Lello</span>
        </div>
    </nav>
    <#include "components/deleteModal.ftl">
    <#include "components/informationBookModal.ftl">
    <div class="container">
        <div class="books_table">
            <div class="book_row">
                <div class="book_cell isbn13">ISBN 13</div>
                <div class="book_cell isbn10">ISBN 10</div>
                <div class="book_cell tittle">Titulo</div>
                <div class="book_cell author">Autor</div>
                <div class="book_cell editorial">Editorial</div>
                <div class="book_cell obliviate">Delete book</div>
                <div class="book_cell information">Book information</div>
            </div>
            <#list getBooksList() as book>
                <div class="book_row">
                    <div class="book_cell isbn13">${book.isbn13}</div>
                    <div class="book_cell isbn10">${book.isbn10}</div>
                    <div class="book_cell tittle">${book.title}</div>
                    <div class="book_cell author">${book.author}</div>
                    <div class="book_cell editorial">${book.publishingHouse}</div>
                    <div data-button="obliviate" data-id="${book.isbn13}" class="book_cell obliviate clickable">Obliviate</div>
                    <div data-button="bookInformation" data-id="${book.isbn13}" class="book_cell information clickable">Veritaserum</div>
                </div>
            </#list>
        </div>
    </div>

</body>
</html>