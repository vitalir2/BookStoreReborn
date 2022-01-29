package style

import kotlinext.js.Record
import kotlinext.js.jso
import mui.material.styles.PaletteColor
import mui.material.styles.createPalette
import mui.system.createTheme

val BookStoreTheme = createTheme(
    options = jso {
        palette = lightPalette.unsafeCast<Record<String, Any>>()
        typography = js("({ h4: { fontFamily: 'sans-serif', fontWeight: 400, fontSize: '48px' } })")
    }
)

val lightPalette = createPalette(
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
)
