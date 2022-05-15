package page.description

import client.HttpClient
import kotlinx.coroutines.launch
import model.Book
import mui.material.Typography
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import page.PageObject
import react.ChildrenBuilder
import react.FC
import react.Props
import react.router.useParams
import react.useEffectOnce
import react.useState
import usecases.GetBookByTitleUseCase

object BookDescriptionPage : PageObject<Props>, KoinComponent {
    const val VAR_BOOK_ID = "bookId"

    val getBookByTitleUseCase by inject<GetBookByTitleUseCase>()

    override val reactComponent: FC<Props> = FC {
        val bookId = useParams()[VAR_BOOK_ID] ?: error("No parameter was passed for $VAR_BOOK_ID")
        val (book, setBook) = useState<Book?>(null)

        useEffectOnce {
            HttpClient.scope.launch {
                setBook(getBookByTitleUseCase(bookId))
            }
        }

        if (book != null) {
            renderBook(book)
        }
    }

    private fun ChildrenBuilder.renderBook(book: Book) {
        Typography {
            +book.title
        }
        Typography {
            +book.description
        }
    }

    override val route: String = "/books/:$VAR_BOOK_ID"
}
