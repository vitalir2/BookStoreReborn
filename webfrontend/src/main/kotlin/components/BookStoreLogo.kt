package components

import csstype.ColorProperty
import kotlinext.js.jso
import mui.icons.material.LocalLibrary
import mui.material.Stack
import mui.material.StackDirection
import mui.material.SvgIconColor
import mui.material.Typography
import mui.system.ResponsiveStyleValue
import react.FC
import react.Props

val BookStoreLogo = FC<Props> {
    Stack {
        sx = jso {
            backgroundColor = "#B71C1C".unsafeCast<ColorProperty>()
        }
        direction = ResponsiveStyleValue(StackDirection.row)
        spacing = ResponsiveStyleValue(2)

        Typography {
            sx = jso {
                color = "white".unsafeCast<ColorProperty>()
            }
            variant = "h4"

            +"BookStore"
        }
        LocalLibrary {
            color = SvgIconColor.primary
        }
    }
}