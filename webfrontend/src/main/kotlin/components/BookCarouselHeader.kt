package components

import csstype.AlignItems
import csstype.ClassName
import csstype.rem
import mui.material.Stack
import mui.material.StackDirection
import mui.material.Typography
import mui.material.styles.TypographyVariant
import mui.system.responsive
import mui.system.sx
import react.FC
import react.Props
import react.router.dom.Link
import style.muiColor

val BookCarouselHeader = FC<BookCarouselHeaderProps> { props ->
    Stack {
        sx {
            alignItems = AlignItems.center
            margin = 2.rem
            marginLeft = 3.rem
            marginBottom = 0.2.rem
        }
        direction = responsive(StackDirection.row)
        spacing = responsive(BOOK_CAROUSEL_HEADER_SPACING)

        Typography {
            className = ClassName("category-title")
            variant = TypographyVariant.h5
            +props.title
        }
        Link {
            className = ClassName("to-everything")
            to = "#"

            Typography {
                sx {
                    color = muiColor("primary.main")
                }
                variant = TypographyVariant.caption
                +"See more"
            }
        }
    }
}

external interface BookCarouselHeaderProps : Props {
    var title: String
}

private const val BOOK_CAROUSEL_HEADER_SPACING = 4
