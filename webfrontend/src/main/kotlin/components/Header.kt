package components

import csstype.AlignItems
import csstype.Color
import csstype.Display
import csstype.FlexDirection
import csstype.JustifyContent
import csstype.Position
import csstype.attr
import csstype.rem
import emotion.react.css
import mui.icons.material.AccountCircle
import mui.icons.material.ShoppingCart
import mui.material.AppBar
import mui.material.Link
import mui.material.LinkUnderline
import mui.material.SvgIconSize
import mui.material.Typography
import mui.material.styles.TypographyVariant
import mui.system.sx
import react.FC
import react.Props
import style.Colors

val Header = FC<Props> {
    AppBar {
        sx {
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
        react.router.dom.Link {
            to = "/cart"

            ShoppingCart {
                sx {
                    color = Color(Colors.white)
                }
                fontSize = SvgIconSize.large
            }
        }
        Typography {
            css {
                before {
                    content = attr("Items: ")
                }
                after {
                    content = attr("$")
                }
            }
            variant = TypographyVariant.h4
            +"0"
        }
        Link {
            sx {
                color = Color(Colors.white)
            }
            underline = LinkUnderline.none
            variant = "h4"
            href = "#"
            +"Browse"
        }
        react.router.dom.Link {
            to = "/login"

            AccountCircle {
                sx {
                    color = Color(Colors.white)
                }
                fontSize = SvgIconSize.large
            }
        }
    }
}
