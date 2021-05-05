package si.dime.kotlin.tutorials.rest.booklibrary.book.primaryadapter


data class BookDocument (val data: List<BookData>)

data class BookData(
    val isbn: String,
    val title: String,
    val author: String,
    val coverURL: String?
)
