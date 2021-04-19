package si.dime.kotlin.tutorials.rest.booklibrary.book.domain

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Duplicated item.")
class DuplicateItemException: RuntimeException() {}
