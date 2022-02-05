package page

import client.HttpClient
import client.getBooksUseCase
import components.BookCarousel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import model.Book
import react.FC
import react.Props
import react.useEffect
import react.useState

val MainPage = FC<Props> {
    val (books, setBooks) = useState(emptyList<Book>())
    useEffect(books) {
        val job = HttpClient.scope.launch(CoroutineExceptionHandler { _, throwable ->
            console.log("Error in coroutine: ${throwable.message}")
        }) {
            setBooks(getBooksUseCase())
        }
        cleanup {
            job.cancel()
        }
    }

    BookCarousel {
        carouselBooks = books
    }
}
