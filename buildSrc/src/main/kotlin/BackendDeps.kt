object BackendDeps {
    const val ktorNetty = "io.ktor:ktor-server-netty:${BackendVersions.ktor}"
    const val logbackClassic = "ch.qos.logback:logback-classic:${BackendVersions.logback}"
    const val ktorHtmlBuilder = "io.ktor:ktor-html-builder:${BackendVersions.ktor}"
    const val kotlinHtmlJvm = "org.jetbrains.kotlinx:kotlinx-html-jvm:${BackendVersions.kotlinHtmlJvm}"
}

object BackendVersions {
    const val ktor = "1.6.3"
    const val logback = "1.2.10"
    const val kotlinHtmlJvm = "0.7.2"
}