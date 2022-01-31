import components.BookStoreLogo
import components.SearchBar
import kotlinx.browser.document
import mui.material.Stack
import mui.material.StackDirection
import mui.material.styles.ThemeProvider
import mui.system.ResponsiveStyleValue
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

        Stack {
            direction = ResponsiveStyleValue(StackDirection.row)

            BookStoreLogo()
            SearchBar()
        }
    }
}
