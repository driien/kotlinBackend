package si.dime.kotlin.tutorials.rest.booklibrary.book.domain

interface BookRepository {
    fun getBooks(): MutableList<Book>
    fun addBook(book: Book): Boolean
}