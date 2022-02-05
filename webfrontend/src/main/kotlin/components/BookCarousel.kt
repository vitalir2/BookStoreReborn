package components

import Carousel
import components.thirdparty.CarouselAnimation
import csstype.Cursor
import csstype.em
import csstype.px
import kotlinx.browser.window
import model.Book
import mui.material.Stack
import mui.material.StackDirection
import mui.material.Typography
import mui.system.ResponsiveStyleValue
import react.FC
import react.Props
import react.css.css
import react.dom.html.ReactHTML.img
import react.key

external interface BookCarouselProps : Props {
    var carouselBooks: List<Book>
}

val BookCarousel = FC<BookCarouselProps> { props ->
    Carousel {
        autoPlay = false
        indicators = false
        swipe = true
        navButtonsAlwaysVisible = true
        cycleNavigation = false
        animation = CarouselAnimation.slide

        val books = props.carouselBooks
        if (books.isEmpty()) {
            Typography {
                variant = "h2"
                +"Internal error"
            }
            return@Carousel
        }

        val itemWidth = when (window.innerWidth) {
            in 0..400 -> 100
            in 400..800 -> 150
            else -> 200
        }
        val batchSize = window.innerWidth / itemWidth - 1
        val repeatCount = books.size / batchSize
        repeat(repeatCount) { index ->
            BookSlide {
                bookItemWidth = itemWidth
                items = books.subList(fromIndex = index * batchSize, toIndex = (index + 1) * batchSize)
            }
        }
    }
}

external interface BookSlideProps : Props {
    var bookItemWidth: Int
    var items: List<Book>
}

val BookSlide = FC<BookSlideProps> { props ->
    Stack {
        direction = ResponsiveStyleValue(StackDirection.row)
        spacing = ResponsiveStyleValue(4)

        for (book in props.items) {
            BookItem {
                key = book.bookId.toString()
                title = book.title
                authors = book.authors.map { "${it.firstName} ${it.lastName}" }
                price = book.price
                imageUrl = book.pictureUrl
                width = props.bookItemWidth
            }
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

            src = props.imageUrl
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
