package components

import csstype.Color
import csstype.rem
import kotlinext.js.jso
import mui.icons.material.LocalLibrary
import mui.material.Stack
import mui.material.StackDirection
import mui.material.Typography
import mui.system.ResponsiveStyleValue
import react.FC
import react.Props
import style.lightPalette

val BookStoreLogo = FC<Props> {
    Stack {
        sx = jso {
            backgroundColor = Color(lightPalette.primary.main)
        }
        direction = ResponsiveStyleValue(StackDirection.row)
        spacing = ResponsiveStyleValue(2)

        Typography {
            sx = jso {
                color = Color(lightPalette.primary.contrastText)
            }
            variant = "h4"

            +"BookStore"
        }
        LocalLibrary {
            sx = jso {
                fontSize = 1.5.rem
                color = Color(lightPalette.primary.contrastText)
            }
        }
    }
}