import components.BookStoreLogo
import kotlinext.js.Record
import kotlinext.js.asJsObject
import kotlinext.js.jso
import kotlinx.browser.document
import mui.material.styles.createPalette
import mui.system.ThemeProvider
import mui.system.createTheme
import react.FC
import react.Props
import react.create
import react.dom.render
import kotlin.js.json

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
    //console.log(Object.keys(json("val" to 5).asJsObject()).toString())
}

val BookStoreTheme = createTheme(
    options = jso {
        palette = createPalette(
            palette = jso {
                mode = "light"
                primary = json(
                    "main" to "#B71C1C",
                    "light" to "#D32F2F",
                    "dark" to "#7F0000",
                    "contrast" to "#ffffff"
                ).asJsObject()
                secondary = json(
                    "main" to "#B71C1C",
                    "light" to "#D32F2F",
                    "dark" to "#7F0000",
                    "contrast" to "#ffffff"
                ).asJsObject()
            }
        ).unsafeCast<Record<String, *>>()
        typography = js("({ h4: { fontFamily: 'sans-serif', fontWeight: 400, fontSize: '48px' } })")
    }
)
