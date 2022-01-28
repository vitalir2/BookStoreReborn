import kotlinx.browser.document
import kotlinx.browser.window
import react.dom.render

fun main() {
    window.onload = {
        render(
            element = BookStoreApp,
            container = document.getElementById("root")
        )
    }
}