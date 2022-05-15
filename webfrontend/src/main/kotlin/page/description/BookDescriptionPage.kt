package page.description

import mui.material.Typography
import org.koin.core.component.KoinComponent
import page.PageObject
import react.FC
import react.Props

object BookDescriptionPage : PageObject<Props>, KoinComponent {
    const val VAR_BOOK_ID = "bookId"

    override val reactComponent: FC<Props> = FC { props ->
        Typography {
            +"Hello!"
        }
    }
    override val route: String = "/books/:$VAR_BOOK_ID"
}
