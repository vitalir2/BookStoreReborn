object BackendDeps {
    const val ktorNetty = "io.ktor:ktor-server-netty:${BackendVersions.ktorCore}"
    const val logbackClassic = "ch.qos.logback:logback-classic:${BackendVersions.logback}"
    const val ktorHtmlBuilder = "io.ktor:ktor-html-builder:${BackendVersions.ktorHtml}"
    const val kotlinHtmlJvm = "org.jetbrains.kotlinx:kotlinx-html-jvm:${BackendVersions.kotlinHtmlJvm}"
}

object BackendVersions {
    const val ktorCore = "2.0.0-beta-1"
    const val ktorHtml = "1.6.7"
    const val logback = "1.2.10"
    const val kotlinHtmlJvm = "0.7.2"
}