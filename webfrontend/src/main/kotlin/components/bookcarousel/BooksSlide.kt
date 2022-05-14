package components.bookcarousel

import csstype.rem
import model.Book
import mui.material.Stack
import mui.material.StackDirection
import mui.system.responsive
import mui.system.sx
import react.ChildrenBuilder
import react.FC
import react.Props
import react.key

val BookSlide = FC<BookSlideProps> { props ->
    Stack {
        sx {
            marginLeft = 2.rem
        }
        direction = responsive(StackDirection.row)
        spacing = responsive(BOOK_SLIDE_SPACING)

        renderBookItems(props.items, props.itemSize)
    }
}

private fun ChildrenBuilder.renderBookItems(
    books: Array<Book>,
    itemSize: ItemSize
) {
    books.forEachIndexed { index, book ->
        BookItem {
            key = book.bookId.toString() + index
            title = book.title
            // TODO @vitalir: Separate preprocessing of books to a new class
            authors = book.authors.map { "${it.firstName} ${it.lastName}" }
            price = book.price
            imageUrl = book.pictureUrl
            width = itemSize.width
            height = itemSize.height
        }
    }
}

external interface BookSlideProps : Props {
    var itemSize: ItemSize
    var items: Array<Book>
}
