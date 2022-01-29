import components.BookStoreLogo
import kotlinx.browser.document
import mui.system.ThemeProvider
import react.FC
import react.Props
import react.create
import react.dom.render
import style.BookStoreTheme

fun main() {
    render(
        element = BookStoreApp.create(),
        container = document.createElement("div").also { document.body!!.appendChild(it) }
    )
}

private val BookStoreApp = FC<Props> {
    ThemeProvider {
        theme = BookStoreTheme

        BookStoreLogo()
    }
}
