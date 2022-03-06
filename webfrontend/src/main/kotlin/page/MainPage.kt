package page

import client.GetPaginatedBooksUseCase
import components.BookCarousel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import react.FC
import react.Props

object MainPage : PageObject, KoinComponent {
    val getPaginatedBooksUseCase by inject<GetPaginatedBooksUseCase>()
    override val reactComponent = FC<Props> {
        BookCarousel()
    }
}
