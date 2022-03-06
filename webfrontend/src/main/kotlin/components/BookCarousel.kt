package components

import Carousel
import client.HttpClient
import client.STANDARD_PAGINATION_LIMIT_STARTER
import client.STANDARD_PAGINATION_OFFSET
import components.thirdparty.CarouselAnimation
import csstype.Cursor
import csstype.em
import csstype.px
import extension.toFixed
import kotlinext.js.jso
import kotlinx.browser.window
import kotlinx.coroutines.launch
import model.Book
import mui.material.Stack
import mui.material.StackDirection
import mui.material.Typography
import mui.system.ResponsiveStyleValue
import page.MainPage
import react.FC
import react.Props
import react.css.css
import react.dom.html.ReactHTML.img
import react.key
import react.useEffectOnce
import react.useState

val BookCarousel = FC<Props> {
    val (books, setBooks) = useState(arrayOf<Book>())

    useEffectOnce {
        val job = HttpClient.scope.launch {
            setBooks(MainPage.getPaginatedBooksUseCase(STANDARD_PAGINATION_OFFSET, STANDARD_PAGINATION_LIMIT_STARTER))
        }
        cleanup {
            job.cancel()
        }
    }
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
