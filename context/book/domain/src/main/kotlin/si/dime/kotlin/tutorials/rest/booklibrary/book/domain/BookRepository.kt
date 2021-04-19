package si.dime.kotlin.tutorials.rest.booklibrary.book.domain

import si.dime.kotlin.tutorials.rest.booklibrary.book.domain.Book

interface BookRepository {
    fun getBooks(): MutableList<Book>
    fun addBook(book: Book): Boolean
}