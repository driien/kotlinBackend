package si.dime.kotlin.tutorials.rest.booklibrary.book.secondaryadapter.persistence

import si.dime.kotlin.tutorials.rest.booklibrary.book.domain.*


//Entity
//Table(name = "book", schema = "BOOKLIBRARY")
data class IBook (
    val isbn: String,
    val title: String,
    val author: String,
    val coverURL: String? = null
) {
    fun toBook() =
        Book(
            isbn = BookISBN(isbn),
            title = BookTitle(title),
            author = BookAuthor(author),
            coverURL= coverURL?.let{BookCoverURL(it)}
        )
}

internal fun Book.toIBook() =
    IBook(
        isbn = isbn(),
        title = title(),
        author =  author(),
        coverURL = coverURL()
    )