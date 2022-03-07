package page

import client.GetPaginatedBooksUseCase
import components.BookCarousel
import components.BookCarouselHeader
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import react.FC
import react.Props

object MainPage : PageObject, KoinComponent {
    val getPaginatedBooksUseCase by inject<GetPaginatedBooksUseCase>()
    override val reactComponent = FC<Props> {
        BookCarouselHeader {
            title = "Best choice"
        }
        BookCarousel()
    }
}
