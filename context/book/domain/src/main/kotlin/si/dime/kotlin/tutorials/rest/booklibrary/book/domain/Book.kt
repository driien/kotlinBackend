package si.dime.kotlin.tutorials.rest.booklibrary.book.domain

data class Book (
    var ISBN: String,
    var title: String,
    var author: String,
    var coverURL: String? = null
)