package si.dime.kotlin.tutorials.rest.booklibrary.book.primaryAdapter

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import si.dime.kotlin.tutorials.rest.booklibrary.book.domain.Book
import si.dime.kotlin.tutorials.rest.booklibrary.book.secondaryAdapter.composite.InMemoryBooksDatabase
import si.dime.kotlin.tutorials.rest.booklibrary.book.domain.DuplicateItemException

@RestController
class BooksController {

    // Our books' database
    @Autowired
    private lateinit var database: InMemoryBooksDatabase

    @RequestMapping("", method = arrayOf(RequestMethod.GET))
    fun books() = database.getBooks()

    @RequestMapping("", method = [RequestMethod.POST])
    fun addBook(@RequestBody book: Book) =
        if (database.addBook(book)) book
        else throw DuplicateItemException()
}