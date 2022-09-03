<!DOCTYPE html>
<html lang="Project of a basic CRUD library">
<head>
    <link rel="stylesheet" href="../main-styles.css">
    <link rel="icon" href="/assets/images/deathly_hallows_sign_black.svg" type="image/x-icon">
    <title>Livraria Lello</title>
</head>
<body>
    <nav>
        <div class="content">
            <img src="/assets/images/deathly_hallows_sign_white.svg" alt="deathly_hallows_sign">
            <span>Livraria Lello</span>
        </div>
    </nav>
    <div class="container">
        <div class="books_table">
            <#list getBooksList() as book>
                <div class="book_row">
                    <div class="book_cell isbn13">${book.isbn13}</div>
                    <div class="book_cell isbn10">${book.isbn10}</div>
                    <div class="book_cell tittle">${book.title}</div>
                    <div class="book_cell author">${book.author}</div>
                    <div class="book_cell editorial">${book.editorial}</div>
                </div>
            </#list>
        </div>
    </div>

</body>
</html>