package si.dime.kotlin.tutorials.rest.booklibrary.book.domain.search

import si.dime.kotlin.tutorials.rest.booklibrary.book.domain.Book
import si.dime.kotlin.tutorials.rest.booklibrary.book.domain.BookRepository

class BookSearcher (private val repository: BookRepository){
    fun invoke(): MutableList<Book> = repository.getBooks()
}