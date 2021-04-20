package si.dime.kotlin.tutorials.rest.booklibrary.book.interaction

import org.axonframework.queryhandling.QueryHandler
import si.dime.kotlin.tutorials.rest.booklibrary.book.domain.Book
import si.dime.kotlin.tutorials.rest.booklibrary.book.domain.search.BookSearcher
import javax.inject.Named

class SearchBookQuery

@Named
open class SearchBookQueryHandler(private val searcher: BookSearcher) {
    @QueryHandler
    open fun handle(query: SearchBookQuery): SearchBookQueryResult {
        return searcher.invoke().toResult()
    }
}

private fun List<Book>.toResult() =
    this.map { book ->
        SearchBookQueryResultBook(
            ISBN = book.ISBN,
            title = book.title,
            author = book.author,
            coverURL = book.coverURL
        )
    }
        .let { SearchBookQueryResult(it) }

data class SearchBookQueryResult(val book: List<SearchBookQueryResultBook>)

data class SearchBookQueryResultBook(
    val ISBN: String,
    val title: String,
    val author: String,
    val coverURL: String? = null
)
