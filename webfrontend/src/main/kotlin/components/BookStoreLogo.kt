package components

import csstype.AlignItems
import csstype.Color
import csstype.Display
import csstype.px
import kotlinx.js.jso
import mui.icons.material.LocalLibrary
import mui.material.Box
import mui.material.SvgIconSize
import mui.material.Typography
import mui.material.styles.TypographyVariant
import mui.system.sx
import react.FC
import react.Props
import react.router.dom.Link
import style.lightPalette

val BookStoreLogo = FC<Props> {
    Box {
        sx {
            display = Display.flex
            alignItems = AlignItems.center
            gap = 8.px

            backgroundColor = Color(lightPalette.primary.main)
        }

        Link {
            to = "/"

            Typography {
                sx = jso {
                    color = Color(lightPalette.primary.contrastText)
                }
                variant = TypographyVariant.h4

                +"BookStore"
            }
        }
        Link {
            to = "/"

            LocalLibrary {
                sx = jso {
                    color = Color(lightPalette.primary.contrastText)
                }
                fontSize = SvgIconSize.large
            }
        }
    }
}
