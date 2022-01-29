object WebFrontendDeps {
    private const val kotlinWrappers = "org.jetbrains.kotlin-wrappers"

    const val reactCore = "$kotlinWrappers:kotlin-react:${WebFrontedVersions.reactCore}"
    const val reactDom = "$kotlinWrappers:kotlin-react-dom:${WebFrontedVersions.reactCore}"
    const val reactRouter = "$kotlinWrappers:kotlin-react-router-dom:${WebFrontedVersions.reactRouter}"
    const val redux = "$kotlinWrappers:kotlin-redux:${WebFrontedVersions.redux}"
    const val reactRedux = "$kotlinWrappers:kotlin-react-redux:${WebFrontedVersions.reactRedux}"
    const val styled = "$kotlinWrappers:kotlin-styled:${WebFrontedVersions.kotlinStyled}"
    const val kotlinJs = "stdlib-js"
}

object WebFrontedVersions {
    const val reactCore = "17.0.2-pre.292-kotlin-1.6.10"
    const val reactRouter = "6.2.1-pre.292-kotlin-1.6.10"
    const val redux = "4.1.2-pre.292-kotlin-1.6.10"
    const val reactRedux = "7.2.6-pre.292-kotlin-1.6.10"
    const val kotlinStyled = "5.3.3-pre.292-kotlin-1.6.10"
}