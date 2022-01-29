import components.BookStoreLogo
import react.Props
import react.dom.html.ReactHTML.div
import react.fc

val BookStoreApp = fc<Props> {
    div {
        BookStoreLogo()
    }
}