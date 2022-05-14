package page

import client.GetPaginatedBooksUseCase
import client.HttpClient
import client.STANDARD_PAGINATION_LIMIT_STARTER
import client.STANDARD_PAGINATION_OFFSET
import components.BookCarouselHeader
import components.bookcarousel.BookCarousel
import kotlinx.coroutines.launch
import model.Book
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import react.FC
import react.Props
import react.useEffectOnce
import react.useState

object MainPage : PageObject, KoinComponent {
    val getPaginatedBooksUseCase by inject<GetPaginatedBooksUseCase>()
    override val reactComponent = FC<Props> {
        val (stateBooks, setBooks) = useState(arrayOf<Book>())

        useEffectOnce {
            val job = HttpClient.scope.launch {
                setBooks(getPaginatedBooksUseCase(STANDARD_PAGINATION_OFFSET, STANDARD_PAGINATION_LIMIT_STARTER))
            }
            cleanup {
                job.cancel()
            }
        }

        BookCarouselHeader {
            title = "Best choice"
        }
        BookCarousel {
            books = stateBooks
        }
        BookCarouselHeader {
            title = "Hot new releases"
        }
        BookCarousel {
            books = stateBooks
        }
    }
}
