package components

import csstype.*
import kotlinext.js.jso
import mui.icons.material.AccountCircle
import mui.icons.material.ShoppingCart
import mui.material.*
import react.FC
import react.Props
import react.css.css
import style.Colors

val Header = FC<Props> {
    AppBar {
        sx = jso {
            height = 4.rem

            position = Position.relative
            display = Display.flex
            flexDirection = FlexDirection.row
            alignItems = AlignItems.center
            justifyContent = JustifyContent.spaceAround

            backgroundColor = Color(Colors.red900)
        }

        BookStoreLogo()
        SearchBar()
        Link {
            href = "#" // TODO: add href to cart page
            ShoppingCart {
                sx = jso {
                    color = Color(Colors.white)
                }
                fontSize = SvgIconSize.large
            }
        }
        Typography {
            css {
                before {
                    +"Items: "
                }
                after {
                    +"$"
                }
            }
            variant = "h4"
            +"0"
        }
        Link {
            sx = jso {
                color = Color(Colors.white)
            }
            underline = LinkUnderline.none
            variant = "h4"
            href = "#"
            +"Browse"
        }
        Link {
            href = "#"
            AccountCircle {
                sx = jso {
                    color = Color(Colors.white)
                }
                fontSize = SvgIconSize.large
            }
        }
    }
}