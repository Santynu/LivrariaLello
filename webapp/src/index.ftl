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

    <div id="deleteModal" class="modal">
        <div class="modal-content">
            <div id="id-box" data-id=""></div>
            <div class="close-wrapper">
                <span class="close">&times;</span>
            </div>
            <div class="message">
                <p>Are you sure you want to delete this book?</p>
            </div>
            <div class="buttons">
                <button id="yesButton">Yes</button>
                <button id="noButton">No</button>
            </div>
        </div>

    </div>
    <div class="container">
        <div class="books_table">
            <div class="book_row">
                <div class="book_cell isbn13">ISBN 13</div>
                <div class="book_cell isbn10">ISBN 10</div>
                <div class="book_cell tittle">Titulo</div>
                <div class="book_cell author">Autor</div>
                <div class="book_cell editorial">Editorial</div>
                <div class="book_cell obliviate">Borrar libro</div>
            </div>
            <#list getBooksList() as book>
                <div class="book_row">
                    <div class="book_cell isbn13">${book.isbn13}</div>
                    <div class="book_cell isbn10">${book.isbn10}</div>
                    <div class="book_cell tittle">${book.title}</div>
                    <div class="book_cell author">${book.author}</div>
                    <div class="book_cell editorial">${book.editorial}</div>
                    <div data-button="obliviate" data-id="${book.isbn13}" class="book_cell obliviate clickable">Obliviate</div>
                </div>
            </#list>
        </div>
    </div>

</body>
</html>