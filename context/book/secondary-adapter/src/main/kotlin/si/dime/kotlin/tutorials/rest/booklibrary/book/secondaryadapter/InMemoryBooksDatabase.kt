package si.dime.kotlin.tutorials.rest.booklibrary.book.secondaryadapter

import org.springframework.stereotype.Component
import si.dime.kotlin.tutorials.rest.booklibrary.book
//import si.dime.kotlin.tutorials.rest.booklibrary.book.domain.BookRepository
import javax.annotation.PostConstruct

@Component
class InMemoryBooksDatabase : BookRepository {
    //All of our books will live here ⬇️
    private val books = mutableListOf<Book>()

    @PostConstruct
    private fun init() {

        // Fill our "database"
        books.add(
            Book(
            "0765326353",
            "The Way of Kings",
            "Brandon Sanderson",
            coverURL = "https://d.gr-assets.com/books/1448127430l/7235533.jpg")
        )

        books.add(
            Book(
            "0345391802",
            "The Hitchhiker's Guide to the Galaxy",
            "Douglas Adams",
            coverURL = "https://d.gr-assets.com/books/1327656754l/11.jpg")
        )

        books.add(
            Book(
            "076531178X",
            "Mistborn: The Final Empire",
            "Brandon Sanderson",
            coverURL = "https://d.gr-assets.com/books/1437254833l/68428.jpg")
        )
    }

    /**
     * Returns a list of all books
     */
    override fun getBooks() = books

    /**
     * Adds the given book only if a book with
     * the same ISBN doesn't already exist.
     *
     * @return  true - if the book was successfully added
     *          false - otherwise
     */
    override fun addBook(book: Book): Boolean {
        books.firstOrNull { it.ISBN == book.ISBN }?.let {
            // A book with the same ISBN exist
            return false
        }

        // If we get to this line -
        // that means a book with the same ISBN
        // doesn't exist.
        books.add(book)
        return true
    }

}