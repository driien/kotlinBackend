package si.dime.kotlin.tutorials.rest.booklibrary.book.domain

data class Book (
    var isbn: BookISBN,
    var title: BookTitle,
    var author: BookAuthor,
    var coverURL: BookCoverURL? = null
) {
    companion object{
        fun create(isbn: BookISBN, title: BookTitle, author: BookAuthor, coverURL: BookCoverURL?) =
            run{
                Book(isbn = isbn, title = title, author = author, coverURL = coverURL)
            }
    }

    fun isbn() = isbn.toString()
    fun title() = title.toString()
    fun author() = author.toString()
    fun coverURL() = coverURL.toString()
}




