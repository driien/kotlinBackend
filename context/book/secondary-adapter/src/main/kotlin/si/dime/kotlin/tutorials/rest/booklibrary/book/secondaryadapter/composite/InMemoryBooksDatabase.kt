package si.dime.kotlin.tutorials.rest.booklibrary.book.secondaryadapter.composite

import si.dime.kotlin.tutorials.rest.booklibrary.book.secondaryadapter.persistence.IBook
import si.dime.kotlin.tutorials.rest.booklibrary.book.secondaryadapter.persistence.IBookRepository
import javax.annotation.PostConstruct
import javax.inject.Named

@Named
class InMemoryBooksDatabase: IBookRepository {
    //All of our books will live here ⬇️
    private val books = mutableListOf<IBook>()

    @PostConstruct
    private fun init() {

        // Fill our "database"
        save(
            IBook(
                "0765326353",
                "The Way of Kings",
                "Brandon Sanderson",
                "https://d.gr-assets.com/books/1448127430l/7235533.jpg"
            )

        )

        save(
            IBook(
                "0345391802",
                "The Hitchhiker's Guide to the Galaxy",
                "Douglas Adams",
                 "https://d.gr-assets.com/books/1327656754l/11.jpg"
            )
        )

        save(
            IBook(
                "076531178X",
                "Mistborn: The Final Empire",
                "Brandon Sanderson",
                 "https://d.gr-assets.com/books/1437254833l/68428.jpg"
            )
        )
    }

    /**
     * Returns a list of all books
     */
    override fun getBooks() = books

    override fun save(ibook: IBook): Boolean {
        books.firstOrNull { it.isbn.equals(ibook.isbn) }?.let {
            // A book with the same ISBN exist
            return false
        }
        // If we get to this line -
        // that means a book with the same ISBN
        // doesn't exist.
        books.add(ibook)
        return true    }

    /**
     * Adds the given book only if a book with
     * the same ISBN doesn't already exist.
     *
     * @return  true - if the book was successfully added
     *          false - otherwise
     */

}