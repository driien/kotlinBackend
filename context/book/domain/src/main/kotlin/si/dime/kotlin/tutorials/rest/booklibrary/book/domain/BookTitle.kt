package si.dime.kotlin.tutorials.rest.booklibrary.book.domain

data class BookTitle (private var value: String){
    override fun toString(): String = value
}