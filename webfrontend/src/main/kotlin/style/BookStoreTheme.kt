package style

import csstype.FontWeight
import csstype.pct
import csstype.rem
import kotlinext.js.jso
import mui.material.styles.PaletteColor
import mui.material.styles.PaletteOptions
import mui.material.styles.createTheme

val BookStoreTheme = createTheme(
    options = jso {
        palette = lightPalette
        typography = jso<TypographyOptions> {
            htmlFontSize = 16
            fontFamily = "sans-serif"
            h1 = jso {
                fontWeight = FontWeight.normal
                fontSize = 7.75.rem
                letterSpacing = (-1.5).pct
            }
            h2 = jso {
                fontWeight = FontWeight.normal
                fontSize = 4.8125.rem
                letterSpacing = (-1.5).pct
            }
            h3 = jso {
                fontWeight = FontWeight.bold
                fontSize = 3.875.rem
                letterSpacing = 0
            }
            h4 = jso {
                fontWeight = FontWeight.normal
                fontSize = 2.75.rem
                letterSpacing = 0.25.pct
            }
            h5 = jso {
                fontWeight = FontWeight.bold
                fontSize = 1.9375.rem
                letterSpacing = 0
            }
            h6 = jso {
                fontWeight = FontWeight.bold
                fontSize = 1.625.rem
                letterSpacing = 0.15.pct
            }
            subtitle1 = jso {
                fontWeight = FontWeight.normal
                fontSize = 1.3125.rem
                letterSpacing = 0.15.pct
            }
            subtitle2 = jso {
                fontWeight = FontWeight.bold
                fontSize = 1.125.rem
                letterSpacing = 0.1.pct
            }
            body1 = jso {
                fontWeight = FontWeight.normal
                fontSize = 1.0625.rem
                letterSpacing = 0.5.pct
            }
            body2 = jso {
                fontWeight = FontWeight.normal
                fontSize = 0.9375.rem
                letterSpacing = 0.25.pct
            }
            button = jso {
                fontWeight = FontWeight.bold
                fontSize = 0.9375.rem
                letterSpacing = 1.25.pct
            }
            caption = jso {
                fontWeight = FontWeight.normal
                fontSize = 1.rem
                letterSpacing = 0.4.pct
            }
            overline = jso {
                fontWeight = FontWeight.normal
                fontSize = 0.625.rem
                letterSpacing = 1.5.pct
            }
        }
    }
)

interface TypographyOptions {
    var htmlFontSize: Number

    var pxToRem: dynamic

    var fontFamily: dynamic

    var fontSize: dynamic

    var fontWeightLight: dynamic

    var fontWeightRegular: dynamic

    var fontWeightMedium: dynamic

    var fontWeightBold: dynamic

    var h1: FontOptions

    var h2: FontOptions

    var h3: FontOptions

    var h4: FontOptions

    var h5: FontOptions

    var h6: FontOptions

    var subtitle1: FontOptions

    var subtitle2: FontOptions

    var body1: FontOptions

    var body2: FontOptions

    var button: FontOptions

    var caption: FontOptions

    var overline: FontOptions
}

interface FontOptions {
    var fontFamily: dynamic

    var fontWeight: dynamic

    var fontSize: dynamic

    var lineHeight: dynamic

    var letterSpacing: dynamic
}

val lightPalette: PaletteOptions =
    jso {
        mode = "light"
        primary = jso<PaletteColor> {
            main = Colors.red900
            light = Colors.red900Light
            dark = Colors.red900Dark
            contrastText = Colors.white
        }
        secondary = jso<PaletteColor> {
            main = Colors.lightBlue100
            light = Colors.lightBlue100Light
            dark = Colors.lightBlue100Dark
            contrastText = Colors.black
        }
        error = jso<PaletteColor> {
            main = Colors.orange600
        }
    }
