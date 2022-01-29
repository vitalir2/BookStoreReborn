import components.BookStoreLogo
import kotlinext.js.Record
import kotlinext.js.jso
import kotlinx.browser.document
import mui.system.ThemeProvider
import mui.system.createTheme
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
    ThemeProvider {
        theme = BookStoreTheme

        BookStoreLogo()
    }
}

val BookStoreTheme = createTheme(
    options = jso {
        palette = js("{ mode: 'light' }").unsafeCast<Record<String, *>>()
        typography = js("({ h4: { fontFamily: 'sans-serif', fontWeight: 400, fontSize: '48px' } })")
    }
)
