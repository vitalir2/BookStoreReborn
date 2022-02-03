package style

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
