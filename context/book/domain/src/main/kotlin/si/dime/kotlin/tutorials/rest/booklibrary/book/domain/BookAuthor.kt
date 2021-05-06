package si.dime.kotlin.tutorials.rest.booklibrary.book.domain

data class BookAuthor (private var value: String){
    override fun toString(): String = value
}