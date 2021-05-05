package si.dime.kotlin.tutorials.rest.booklibrary.book.domain.search

import si.dime.kotlin.tutorials.rest.booklibrary.book.domain.BookRepository
import javax.inject.Named

@Named
class BookSearcher (private val repository: BookRepository){
    fun invoke() = repository.getBooks()
}