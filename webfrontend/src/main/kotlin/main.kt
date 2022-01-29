import components.BookStoreLogo
import kotlinx.browser.document
import react.FC
import react.Props
import react.create
import react.dom.render

fun main() {
    render(
        element = BookStoreApp.create(),
        container = document.createElement("div").also { document.body!!.appendChild(it) }
    )
}

private val BookStoreApp = FC<Props> {
    BookStoreLogo()
}
