package si.dime.kotlin.tutorials.rest.booklibrary.book.primaryadapter.create

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import si.dime.kotlin.tutorials.rest.booklibrary.book.domain.Book

class CreateBookController {
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