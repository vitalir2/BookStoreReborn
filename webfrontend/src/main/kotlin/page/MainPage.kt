package page

import Carousel
import components.thirdparty.CarouselAnimation
import csstype.Cursor
import csstype.em
import csstype.px
import kotlinx.browser.window
import mui.material.Stack
import mui.material.StackDirection
import mui.material.Typography
import mui.system.ResponsiveStyleValue
import react.FC
import react.Props
import react.css.css
import react.dom.html.ReactHTML.img

val MainPage = FC<Props> {
    Carousel {
        autoPlay = false
        indicators = false
        swipe = true
        navButtonsAlwaysVisible = true
        cycleNavigation = false
        animation = CarouselAnimation.slide

        repeat(2) {
            BookSlide {
                bookItemWidth = when (window.innerWidth) {
                    in 0..400 -> 100
                    in 400..800 -> 150
                    else -> 200
                }
            }
        }
    }
}

external interface BookSlideProps : Props {
    var bookItemWidth: Int
}

val BookSlide = FC<BookSlideProps> { props ->
    Stack {
        direction = ResponsiveStyleValue(StackDirection.row)
        spacing = ResponsiveStyleValue(4)

        val stubTitle = "Title of the book"
        val stubAuthors = listOf("Chen Pin", "Joe Funny")
        val stubPrice = 2.5

        val windowWidth = window.innerWidth
        repeat(windowWidth / props.bookItemWidth - 1) {
            BookItem {
                title = stubTitle
                authors = stubAuthors
                price = stubPrice
                imageUrl = null
                width = props.bookItemWidth
            }
        }
    }
}

val BookItem = FC<BookProps> { props ->
    Stack {
        direction = ResponsiveStyleValue(StackDirection.column)
        spacing = ResponsiveStyleValue(1)

        img {
            css {
                width = (props.width).px
                height = 20.em
                cursor = Cursor.pointer
            }

            // TODO: Remove after client integration
            src =
                "https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2F3.bp.blogspot.com%2F-HxVxhy2RH-0%2FVANY1W2HZRI%2FAAAAAAAAEig%2Fvi6vPNg85ns%2Fs1600%2FTheHungerGames.jpg&f=1&nofb=1"
        }
        Typography {
            +props.title
        }
        Typography {
            +props.authors.joinToString(", ")
        }
        Typography {
            +props.price.toString()
        }
    }
}

external interface BookProps : Props {
    var title: String
    var authors: List<String>
    var price: Double
    var imageUrl: String?
    var width: Int
}