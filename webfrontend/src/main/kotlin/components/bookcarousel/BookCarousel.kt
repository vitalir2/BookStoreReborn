package components.bookcarousel

import Carousel
import components.thirdparty.CarouselAnimation
import csstype.em
import csstype.px
import kotlinx.browser.window
import model.Book
import mui.material.Typography
import mui.material.styles.TypographyVariant
import mui.system.sx
import react.ChildrenBuilder
import react.FC
import react.Props

val BookCarousel = FC<BookCarouselProps> { props ->
    Carousel {
        sx {
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
            renderOnEmpty()
            return@Carousel
        }
        val metrics = calculateGeneralBookSlideMetrics(books.size)
        renderSlides(metrics, books)
    }
}

private fun ChildrenBuilder.renderOnEmpty() {
    Typography {
        variant = TypographyVariant.h2
        +"Internal error" // TODO @vitalir: Is not an error if empty carousel but something more general
    }
}

private fun ChildrenBuilder.renderSlides(
    metrics: BookSlideMetrics,
    books: Array<Book>
) {
    val batchSize = metrics.batchSize
    repeat(metrics.repeatCount) { index ->
        val fromIndex = index * batchSize
        val toIndex = minOf((index + 1) * batchSize, books.size - 1)
        BookSlide {
            itemSize = ItemSize(
                width = metrics.itemWidth.px,
                height = metrics.itemHeightEm.em
            )
            items = books.sliceArray(fromIndex until toIndex)
        }
    }
}

external interface BookCarouselProps : Props {
    var books: Array<Book>
}

private data class BookSlideMetrics(
    val itemWidth: Int,
    val itemHeightEm: Int,
    val batchSize: Int,
    val repeatCount: Int
)

private fun calculateGeneralBookSlideMetrics(
    booksCount: Int,
    itemHeightEm: Int = 20
): BookSlideMetrics {
    val itemWidth = when (window.innerWidth) {
        in 0..SMALL_SCREEN_UPPER_BOUND -> SMALL_SCREEN_BOOK_WIDTH
        in MEDIUM_SCREEN_LOWER_BOUND..MEDIUM_SCREEN_UPPER_BOUND -> MEDIUM_SCREEN_BOOK_WIDTH
        else -> LARGE_SCREEN_BOOK_WIDTH
    }
    val batchSize = window.innerWidth / (itemWidth + COEF_STACK_SPACING_TO_PX * BOOK_SLIDE_SPACING)
    val repeatCount = booksCount / batchSize + 1
    return BookSlideMetrics(
        itemWidth = itemWidth,
        itemHeightEm = itemHeightEm,
        batchSize = batchSize,
        repeatCount = repeatCount
    )
}

private const val SMALL_SCREEN_UPPER_BOUND = 400
private const val SMALL_SCREEN_BOOK_WIDTH = 100
private const val MEDIUM_SCREEN_LOWER_BOUND = 400
private const val MEDIUM_SCREEN_UPPER_BOUND = 800
private const val MEDIUM_SCREEN_BOOK_WIDTH = 150
private const val LARGE_SCREEN_BOOK_WIDTH = 200
