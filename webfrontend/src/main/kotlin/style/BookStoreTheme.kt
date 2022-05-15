package style

import csstype.Color
import csstype.FontWeight
import csstype.pct
import kotlinx.js.jso
import mui.material.PaletteMode
import mui.material.styles.PaletteColor
import mui.material.styles.createTheme

val BookStoreTheme = createTheme(
    options = jso {
        palette = jso {
            mode = PaletteMode.light
            primary = jso<PaletteColor> {
                main = Color(Colors.red900)
                light = Color(Colors.red900Light)
                dark = Color(Colors.red900Dark)
                contrastText = Color(Colors.white)
            }
            secondary = jso<PaletteColor> {
                main = Color(Colors.lightBlue100)
                light = Color(Colors.lightBlue100Light)
                dark = Color(Colors.lightBlue100Dark)
                contrastText = Color(Colors.black)
            }
            error = jso<PaletteColor> {
                main = Color(Colors.orange600)
            }
        }
        typography = jso<TypographyOptions> {
            htmlFontSize = 16
            fontFamily = FontFamily.LATO
            h1 = jso {
                fontFamily = FontFamily.JOSEFIN_SANS
                fontWeight = FontWeight.normal
                fontSize = 124.pixelsToRem()
                letterSpacing = (-1.5).pct
            }
            h2 = jso {
                fontFamily = FontFamily.JOSEFIN_SANS
                fontWeight = FontWeight.normal
                fontSize = 77.pixelsToRem()
                letterSpacing = (-1.5).pct
            }
            h3 = jso {
                fontFamily = FontFamily.JOSEFIN_SANS
                fontWeight = FontWeight.bold
                fontSize = 62.pixelsToRem()
                letterSpacing = 0
            }
            h4 = jso {
                fontFamily = FontFamily.JOSEFIN_SANS
                fontWeight = FontWeight.normal
                fontSize = 44.pixelsToRem()
                letterSpacing = 0.25.pct
            }
            h5 = jso {
                fontFamily = FontFamily.JOSEFIN_SANS
                fontWeight = FontWeight.bold
                fontSize = 31.pixelsToRem()
                letterSpacing = 0
            }
            h6 = jso {
                fontFamily = FontFamily.JOSEFIN_SANS
                fontWeight = FontWeight.bold
                fontSize = 26.pixelsToRem()
                letterSpacing = 0.15.pct
            }
            subtitle1 = jso {
                fontFamily = FontFamily.JOSEFIN_SANS
                fontWeight = FontWeight.normal
                fontSize = 21.pixelsToRem()
                letterSpacing = 0.15.pct
            }
            subtitle2 = jso {
                fontFamily = FontFamily.JOSEFIN_SANS
                fontWeight = FontWeight.bold
                fontSize = 18.pixelsToRem()
                letterSpacing = 0.1.pct
            }
            body1 = jso {
                fontFamily = FontFamily.LATO
                fontWeight = FontWeight.normal
                fontSize = 17.pixelsToRem()
                letterSpacing = 0.5.pct
            }
            body2 = jso {
                fontFamily = FontFamily.LATO
                fontWeight = FontWeight.normal
                fontSize = 15.pixelsToRem()
                letterSpacing = 0.25.pct
            }
            button = jso {
                fontFamily = FontFamily.LATO
                fontWeight = FontWeight.bold
                fontSize = 15.pixelsToRem()
                letterSpacing = 1.25.pct
            }
            caption = jso {
                fontFamily = FontFamily.LATO
                fontWeight = FontWeight.normal
                fontSize = 16.pixelsToRem()
                letterSpacing = 0.4.pct
            }
            overline = jso {
                fontFamily = FontFamily.LATO
                fontWeight = FontWeight.normal
                fontSize = 10.pixelsToRem()
                letterSpacing = 1.5.pct
            }
        }
    }
)
