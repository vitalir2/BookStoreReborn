package components

import Carousel
import components.thirdparty.CarouselAnimation
import csstype.Cursor
import csstype.em
import csstype.px
import csstype.rem
import extension.toFixed
import kotlinext.js.jso
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

val BookCarousel = FC<BookCarouselProps> { props ->
    Carousel {
        sx = jso {
            margin = 1.em
        }
        autoPlay = false
        indicators = false
        swipe = true
        navButtonsAlwaysVisible = true
        cycleNavigation = true
        animation = CarouselAnimation.slide

        val books = props.books
        if (books.isEmpty()) {
            Typography {
                variant = "h2"
                +"Internal error"
            }
            return@Carousel
        }
        val (itemWidth, batchSize, repeatCount) = calculateGeneralBookSlideMetrics(books.size)
        repeat(repeatCount) { index ->
            val fromIndex = index * batchSize
            val toIndex = minOf((index + 1) * batchSize, books.size - 1)
            BookSlide {
                bookItemWidth = itemWidth
                items = books.sliceArray(fromIndex until toIndex)
            }
        }
    }
}

external interface BookCarouselProps : Props {
    var books: Array<Book>
}

private data class BookSlideMetrics(
    val itemWidth: Int,
    val batchSize: Int,
    val repeatCount: Int
)

private fun calculateGeneralBookSlideMetrics(
    booksCount: Int
): BookSlideMetrics {
    val itemWidth = when (window.innerWidth) {
        in 0..400 -> 100
        in 400..800 -> 150
        else -> 200
    }
    val batchSize = window.innerWidth / (itemWidth + COEF_STACK_SPACING_TO_PX * BOOK_SLIDE_SPACING)
    val repeatCount = booksCount / batchSize + 1
    return BookSlideMetrics(itemWidth, batchSize, repeatCount)
}

external interface BookSlideProps : Props {
    var bookItemWidth: Int
    var items: Array<Book>
}

val BookSlide = FC<BookSlideProps> { props ->
    Stack {
        sx = jso {
            marginLeft = 2.rem
        }
        direction = ResponsiveStyleValue(StackDirection.row)
        spacing = ResponsiveStyleValue(BOOK_SLIDE_SPACING)

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

private const val BOOK_SLIDE_SPACING = 4
private const val COEF_STACK_SPACING_TO_PX = 8

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
            +"${(props.price.toFixed(2))} $"
        }
    }
}
