package page

import client.HttpClient
import client.getBooksUseCase
import components.BookCarousel
import kotlinx.coroutines.launch
import model.Book
import react.FC
import react.Props
import react.useEffectOnce
import react.useState

val MainPage = FC<Props> {
    val (books, setBooks) = useState(arrayOf<Book>())

    useEffectOnce {
        val job = HttpClient.scope.launch {
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
