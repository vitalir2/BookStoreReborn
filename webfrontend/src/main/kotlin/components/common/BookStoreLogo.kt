package components.common

import csstype.AlignItems
import csstype.Display
import csstype.px
import mui.icons.material.LocalLibrary
import mui.material.Box
import mui.material.SvgIconSize
import mui.material.Typography
import mui.material.styles.TypographyVariant
import mui.system.sx
import react.FC
import react.Props
import react.router.dom.Link

val BookStoreLogo = FC<Props> {
    Box {
        sx {
            display = Display.flex
            alignItems = AlignItems.center
            gap = 8.px
        }

        Link {
            to = "/"

            Typography {
                variant = TypographyVariant.h4

                +"BookStore"
            }
        }
        Link {
            to = "/"

            LocalLibrary {
                fontSize = SvgIconSize.large
            }
        }
    }
}
