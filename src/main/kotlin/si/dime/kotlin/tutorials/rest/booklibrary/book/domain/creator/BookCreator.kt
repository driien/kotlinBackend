package si.dime.kotlin.tutorials.rest.booklibrary.book.domain.creator

import si.dime.kotlin.tutorials.rest.booklibrary.book.domain.Book
import si.dime.kotlin.tutorials.rest.booklibrary.book.domain.BookRepository

class BookCreator(private val repository: BookRepository) {
    fun invoke(book: Book): Boolean = repository.addBook(book)
}
