package page

import client.HttpClient
import client.STANDARD_LIMIT_SCALE
import client.STANDARD_PAGINATION_LIMIT_STARTER
import client.STANDARD_PAGINATION_OFFSET
import client.getPaginatedBooksUseCase
import components.BookCarousel
import kotlinx.coroutines.launch
import model.Book
import react.FC
import react.Props
import react.useEffect
import react.useState

val MainPage = FC<Props> {
    val (books, setBooks) = useState(arrayOf<Book>())
    val (limit, setLimit) = useState(STANDARD_PAGINATION_LIMIT_STARTER)
    val (carouselPosition, setCarouselPosition) = useState(0)

    useEffect(limit) {
        val job = HttpClient.scope.launch {
            setBooks(getPaginatedBooksUseCase(STANDARD_PAGINATION_OFFSET, limit))
        }
        cleanup {
            job.cancel()
        }
    }

    BookCarousel {
        carouselBooks = books
        currentIndex = carouselPosition
        onScroll = { next, _, batchSize ->
            if (next * batchSize > (STANDARD_PAGINATION_OFFSET + limit) / 2) {
                setLimit((limit * STANDARD_LIMIT_SCALE).toInt())
                setCarouselPosition(next)
            }
        }
    }
}
