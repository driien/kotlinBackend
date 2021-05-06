package si.dime.kotlin.tutorials.rest.booklibrary.book.domain

interface BookRepository {
    fun getBooks(): List<Book>
    fun save(book: Book): Boolean
}