object WebFrontendDeps {
    private const val kotlinWrappers = "org.jetbrains.kotlin-wrappers"

    const val reactCore = "$kotlinWrappers:kotlin-react:${WebFrontedVersions.reactCore}"
    const val reactDom = "$kotlinWrappers:kotlin-react-dom:${WebFrontedVersions.reactCore}"
    const val reactCss = "$kotlinWrappers:kotlin-react-css:${WebFrontedVersions.reactCore}"
    const val reactRouter = "$kotlinWrappers:kotlin-react-router-dom:${WebFrontedVersions.reactRouter}"
    const val redux = "$kotlinWrappers:kotlin-redux:${WebFrontedVersions.redux}"
    const val reactRedux = "$kotlinWrappers:kotlin-react-redux:${WebFrontedVersions.reactRedux}"

    const val styled = "$kotlinWrappers:kotlin-styled:${WebFrontedVersions.kotlinStyled}"
    const val kotlinMui = "$kotlinWrappers:kotlin-mui:${WebFrontedVersions.mui}"
    const val kotlinMuiIcons = "$kotlinWrappers:kotlin-mui-icons:${WebFrontedVersions.mui}"

    const val ktorClientJs = "io.ktor:ktor-client-js:${SharedVersions.ktor}"
    const val kotlinCoroutinesJs = "org.jetbrains.kotlinx:kotlinx-coroutines-core-js:${SharedVersions.kotlinCoroutines}"

    const val kotlinJs = "stdlib-js"

    object Npm {
        const val emotionReact = "@emotion/react"
        const val emotionStyled = "@emotion/styled"
    }
}

object WebFrontedVersions {
    private const val kotlinPostfix = "-pre.292-kotlin-1.6.10"

    const val reactCore = "17.0.2$kotlinPostfix"
    const val reactRouter = "6.2.1$kotlinPostfix"
    const val redux = "4.1.2$kotlinPostfix"
    const val reactRedux = "7.2.6$kotlinPostfix"
    const val kotlinStyled = "5.3.3$kotlinPostfix"
    const val mui = "5.3.1$kotlinPostfix"

    const val emotionReact = "11.7.1"
    const val emotionStyled = "11.6.0"
}