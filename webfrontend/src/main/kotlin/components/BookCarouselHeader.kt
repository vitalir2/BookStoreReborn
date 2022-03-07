package components

import csstype.AlignItems
import csstype.Color
import csstype.rem
import kotlinext.js.jso
import mui.material.Stack
import mui.material.StackDirection
import mui.material.Typography
import mui.system.ResponsiveStyleValue
import react.FC
import react.Props
import react.router.dom.Link
import style.Colors

val BookCarouselHeader = FC<BookCarouselHeaderProps> { props ->
    Stack {
        sx = jso {
            alignItems = AlignItems.center
            margin = 2.rem
            marginLeft = 3.rem
            marginBottom = 0.2.rem
        }
        direction = ResponsiveStyleValue(StackDirection.row)
        spacing = ResponsiveStyleValue(BOOK_CAROUSEL_HEADER_SPACING)

        Typography {
            className = "category-title"
            variant = "h5"
            +props.title
        }
        Link {
            className = "to-everything"
            to = "#"

            Typography {
                sx = jso {
                    color = Color(Colors.red900)
                }
                variant = "caption"
                +"See more"
            }
        }
    }
}

external interface BookCarouselHeaderProps : Props {
    var title: String
}

private const val BOOK_CAROUSEL_HEADER_SPACING = 4
