package si.dime.kotlin.tutorials.rest.booklibrary.book.primaryadapter.rest.search

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import si.dime.kotlin.tutorials.rest.booklibrary.book.domain.Book
import si.dime.kotlin.tutorials.rest.booklibrary.book.interaction.SearchBookQuery
import si.dime.kotlin.tutorials.rest.booklibrary.book.interaction.SearchBookQueryResult
import si.dime.kotlin.tutorials.rest.booklibrary.book.primaryadapter.rest.BookDocument
import si.dime.kotlin.tutorials.rest.booklibrary.librarysource.commandquery.query.QueryBus
import si.dime.kotlin.tutorials.rest.booklibrary.librarysource.commandquery.query.execute

@RestController
class BooksController (private val queryBus: QueryBus){

    @GetMapping("/api-books")
    fun search(): BookDocument {
        return searchBook().fold(
            { throw it },
            { it.toResult() }
        )
    }

    private fun searchBook() = queryBus.execute<SearchBookQueryResult>(SearchBookQuery())

    private fun SearchBookQueryResult.toResult() =
        BookDocument(
            data = this.book.map
            {
                Book(
                    ISBN = it.ISBN,
                    title = it.title,
                    author = it.author,
                    coverURL = it.coverURL
                )
            }
        )


}