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
    var carouselBooks: Array<Book>
    var currentIndex: Int
    var onScroll: (next: Int, prev: Int, batchSize: Int) -> Unit
}

val BookCarousel = FC<BookCarouselProps> { props ->
    Carousel {
        autoPlay = false
        indicators = false
        swipe = true
        navButtonsAlwaysVisible = true
        cycleNavigation = false
        animation = CarouselAnimation.slide
        index = props.currentIndex

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
        onChange = { next: Int, prev: Int ->
            props.onScroll(next, prev, batchSize)
        }
        val repeatCount = books.size / batchSize + 1
        repeat(repeatCount) { index ->
            val fromIndex = index * batchSize
            var toIndex = (index + 1) * batchSize
            if (toIndex >= books.size) {
                toIndex = books.size - 1
            }
            BookSlide {
                bookItemWidth = itemWidth
                items = books.sliceArray(fromIndex..toIndex)
            }
        }
    }
}

external interface BookSlideProps : Props {
    var bookItemWidth: Int
    var items: Array<Book>
}

val BookSlide = FC<BookSlideProps> { props ->
    Stack {
        direction = ResponsiveStyleValue(StackDirection.row)
        spacing = ResponsiveStyleValue(4)

        props.items.forEachIndexed { index, book ->
            BookItem {
                key = book.bookId.toString() + index
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
