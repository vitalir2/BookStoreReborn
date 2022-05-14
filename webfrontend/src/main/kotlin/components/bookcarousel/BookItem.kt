package components.bookcarousel

import csstype.Cursor
import csstype.Length
import emotion.react.css
import extension.toFixed
import mui.material.Stack
import mui.material.StackDirection
import mui.material.Typography
import mui.system.responsive
import react.FC
import react.Props
import react.dom.html.ReactHTML
import react.router.dom.Link

val BookItem = FC<BookProps> { props ->
    Stack {
        direction = responsive(StackDirection.column)
        spacing = responsive(1)

        Link {
            to = "books/123" // TODO @vitalir: Set book ID
            ReactHTML.img {
                css {
                    width = props.width
                    height = props.height
                    cursor = Cursor.pointer
                }

                src = props.imageUrl
            }
        }
        Typography {
            +props.title
        }
        Typography {
            +props.authors.joinToString(", ")
        }
        Typography {
            +"${(props.price.toFixed(2))} $"
        }
    }
}

external interface BookProps : Props {
    var title: String
    var authors: List<String>
    var price: Double
    var imageUrl: String?
    var width: Length
    var height: Length
}
