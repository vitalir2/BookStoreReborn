import react.Props
import react.dom.ReactHTML.div
import react.dom.ReactHTML.h1
import react.fc

val BookStoreApp = fc<Props> {
    div {
        h1 {
            +"Hello world!"
        }
    }
}