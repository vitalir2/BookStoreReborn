object WebFrontendDeps {
    private const val kotlinWrappers = "org.jetbrains.kotlin-wrappers"
    private const val kotlinWrappersVersion = "1.0.0-pre.336"

    private fun kotlinw(name: String) =
        "$kotlinWrappers:kotlin-$name"

    val kotlinWrapperBom = kotlinw("wrappers-bom:$kotlinWrappersVersion")
    val reactCore = kotlinw("react")
    val reactDom = kotlinw("react-dom")
    val reactRouter = kotlinw("react-router-dom")
    val redux = kotlinw("redux")
    val reactRedux = kotlinw("react-redux")

    val emotion = kotlinw("emotion")
    val styled = kotlinw("styled")
    val kotlinMui = kotlinw("mui")
    val kotlinMuiIcons = kotlinw("mui-icons")

    val ktorClientJs = "io.ktor:ktor-client-js:${SharedVersions.ktor}"
    val kotlinCoroutinesJs = "org.jetbrains.kotlinx:kotlinx-coroutines-core-js:${SharedVersions.kotlinCoroutines}"

    val kotlinJs = "stdlib-js"

    object Npm {
        const val emotionReact = "@emotion/react"
        const val emotionStyled = "@emotion/styled"
    }
}

object WebFrontedVersions {

}
