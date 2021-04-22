package si.dime.kotlin.tutorials.rest.booklibrary.book.primaryadapter.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import si.dime.kotlin.tutorials.rest.booklibrary.book.domain.Book
import si.dime.kotlin.tutorials.rest.booklibrary.book.domain.DuplicateItemException
import si.dime.kotlin.tutorials.rest.booklibrary.librarysource.commandquery.query.QueryBus

@RestController
class BooksController (private val queryBus: QueryBus){

    @GetMapping("/api-books")
    fun search() {
        /** TODO BookDocumentList */
    }


    @PostMapping("/book")
    fun addBook(@RequestBody book: Book) {
       /* if (database.addBook(book)) {
            book
        }
        else {
            throw DuplicateItemException()
        }*/
     }

}
