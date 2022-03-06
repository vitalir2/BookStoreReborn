package components

import Carousel
import client.HttpClient
import client.STANDARD_LIMIT_SCALE
import client.STANDARD_PAGINATION_LIMIT_STARTER
import client.STANDARD_PAGINATION_OFFSET
import components.thirdparty.CarouselAnimation
import csstype.Cursor
import csstype.em
import csstype.px
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
import react.useEffect
import react.useState

val BookCarousel = FC<Props> {
    val (currentIndex, setCurrentIndex) = useState(0)
    val (books, setBooks) = useState(arrayOf<Book>())
    val (limit, setLimit) = useState(STANDARD_PAGINATION_LIMIT_STARTER)

    useEffect(limit) {
        val job = HttpClient.scope.launch {
            setBooks(MainPage.getPaginatedBooksUseCase(STANDARD_PAGINATION_OFFSET, limit))
        }
        cleanup {
            job.cancel()
        }
    }
    Carousel {
        autoPlay = false
        indicators = false
        swipe = true
        navButtonsAlwaysVisible = true
        cycleNavigation = false
        animation = CarouselAnimation.slide
        index = currentIndex

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
        onChange = { next: Int, _: Int ->
            if (next * batchSize > (STANDARD_PAGINATION_OFFSET + limit) / 2) {
                setCurrentIndex(next)
                setLimit((limit * STANDARD_LIMIT_SCALE).toInt())
            }
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
