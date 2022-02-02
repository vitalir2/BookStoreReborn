import components.Header
import kotlinx.browser.document
import mui.material.styles.ThemeProvider
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

        Header()
    }
}
