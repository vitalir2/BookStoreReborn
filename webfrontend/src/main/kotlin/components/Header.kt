package components

import csstype.AlignItems
import csstype.Color
import csstype.Display
import csstype.FlexDirection
import csstype.JustifyContent
import csstype.Position
import csstype.rem
import mui.icons.material.AccountCircle
import mui.icons.material.ShoppingCart
import mui.material.AppBar
import mui.material.LinkUnderline
import mui.material.SvgIconSize
import mui.material.Typography
import mui.material.styles.TypographyVariant
import mui.system.sx
import react.FC
import react.Props
import style.Colors
import mui.material.Link as MuiLink
import react.router.dom.Link as RouterLink

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
        ShoppingCartLink()
        Typography {
            variant = TypographyVariant.h4
            +"Items: 0 $"
        }
        BrowseLink()
        AccountLink()
    }
}

private val ShoppingCartLink: FC<Props> = FC {
    RouterLink {
        to = "/cart"

        ShoppingCart {
            sx {
                color = Color(Colors.white)
            }
            fontSize = SvgIconSize.large
        }
    }
}

private val BrowseLink: FC<Props> = FC {
    MuiLink {
        sx {
            color = Color(Colors.white)
        }
        underline = LinkUnderline.none
        variant = "h4"
        href = "#"
        +"Browse"
    }
}

private val AccountLink: FC<Props> = FC {
    RouterLink {
        to = "/login"

        AccountCircle {
            sx {
                color = Color(Colors.white)
            }
            fontSize = SvgIconSize.large
        }
    }
}
