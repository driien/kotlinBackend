package si.dime.kotlin.tutorials.rest.booklibrary.book.secondaryadapter.composite

import si.dime.kotlin.tutorials.rest.booklibrary.book.domain.Book
import si.dime.kotlin.tutorials.rest.booklibrary.book.domain.BookRepository
import si.dime.kotlin.tutorials.rest.booklibrary.book.secondaryadapter.persistence.IBookRepository
import si.dime.kotlin.tutorials.rest.booklibrary.book.secondaryadapter.persistence.toIBook
import javax.inject.Named

@Named
class PersistenceBookRepository(private val database: IBookRepository) : BookRepository {
    override fun getBooks(): List<Book> = database.getBooks().map { it.toBook() }

    override fun save(book: Book) = database.save(book.toIBook())
}