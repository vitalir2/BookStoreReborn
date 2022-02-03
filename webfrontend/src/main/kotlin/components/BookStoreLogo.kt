package components

import csstype.AlignItems
import csstype.Color
import csstype.Display
import csstype.px
import kotlinext.js.jso
import mui.icons.material.LocalLibrary
import mui.material.Box
import mui.material.SvgIconSize
import mui.material.Typography
import react.FC
import react.Props
import style.lightPalette

val BookStoreLogo = FC<Props> {
    Box {
        sx = jso {
            display = Display.flex
            alignItems = AlignItems.center
            gap = 8.px

            backgroundColor = Color(lightPalette.primary.main)
        }

        Typography {
            sx = jso {
                color = Color(lightPalette.primary.contrastText)
            }
            variant = "h4"

            +"BookStore"
        }
        LocalLibrary {
            sx = jso {
                color = Color(lightPalette.primary.contrastText)
            }
            fontSize = SvgIconSize.large
        }
    }
}