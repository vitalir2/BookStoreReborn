import react.Props
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h1
import react.fc

val BookStoreApp = fc<Props> {
    div {
        h1 {
            +"Hello world!"
        }
    }
}