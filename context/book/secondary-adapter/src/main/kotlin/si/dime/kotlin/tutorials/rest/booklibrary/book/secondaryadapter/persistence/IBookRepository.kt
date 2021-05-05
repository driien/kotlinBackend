package si.dime.kotlin.tutorials.rest.booklibrary.book.secondaryadapter.persistence

interface IBookRepository {
    fun getBooks(): MutableList<IBook>
    fun save(ibook: IBook): Boolean
}