object BackendDeps {
    // Ktor
    const val ktorNetty = "io.ktor:ktor-server-netty:${SharedVersions.ktor}"
    const val logbackClassic = "ch.qos.logback:logback-classic:${BackendVersions.logback}"
    const val ktorHtmlBuilder = "io.ktor:ktor-server-html-builder:${SharedVersions.ktor}"
    const val ktorServerCore = "io.ktor:ktor-server-core:${SharedVersions.ktor}"
    const val ktorAuth = "io.ktor:ktor-server-auth:${SharedVersions.ktor}"
    const val ktorLocations = "io.ktor:ktor-server-locations:${SharedVersions.ktor}"
    const val ktorClientCore = "io.ktor:ktor-client-core:${SharedVersions.ktor}"
    const val ktorClientJvm = "io.ktor:ktor-client-core-jvm:${SharedVersions.ktor}"
    const val ktorClientApache = "io.ktor:ktor-client-apache:${SharedVersions.ktor}"
    const val ktorSessions = "io.ktor:ktor-server-sessions:${SharedVersions.ktor}"
    const val ktorAutoHeadResponse = "io.ktor:ktor-server-auto-head-response:${SharedVersions.ktor}"
    const val ktorServerHostCommon = "io.ktor:ktor-server-host-common:${SharedVersions.ktor}"
    const val ktorStatusPages = "io.ktor:ktor-server-status-pages:${SharedVersions.ktor}"
    const val ktorCachingHeaders = "io.ktor:ktor-server-caching-headers:${SharedVersions.ktor}"
    const val ktorCompression = "io.ktor:ktor-server-compression:${SharedVersions.ktor}"
    const val ktorConditionalHeaders = "io.ktor:ktor-server-conditional-headers:${SharedVersions.ktor}"
    const val ktorContentNegotiation = "io.ktor:ktor-server-content-negotiation:${SharedVersions.ktor}"
    const val ktorDefaultHeaders = "io.ktor:ktor-server-default-headers:${SharedVersions.ktor}"
    const val ktorCallLogging = "io.ktor:ktor-server-call-logging:${SharedVersions.ktor}"
    const val ktorServerWebsocket = "io.ktor:ktor-server-websockets:${SharedVersions.ktor}"
    const val ktorServerTests = "io.ktor:ktor-server-tests:${SharedVersions.ktor}"
    const val ktorCors = "io.ktor:ktor-server-cors:${SharedVersions.ktor}"

    // Kotlin
    const val kotlinHtmlJvm = "org.jetbrains.kotlinx:kotlinx-html-jvm:${BackendVersions.kotlinHtmlJvm}"
    const val kotlinCssJvm = "org.jetbrains.kotlin-wrappers:kotlin-css:${BackendVersions.kotlinCssJvm}"
    const val kotlinTestJunit = "org.jetbrains.kotlin:kotlin-test-junit:${SharedVersions.kotlin}"

    // Exposed
    private const val exposedDependenciesPrefix = "org.jetbrains.exposed"
    const val exposedCore = "$exposedDependenciesPrefix:exposed-core:${BackendVersions.exposed}"
    const val exposedDao = "$exposedDependenciesPrefix:exposed-dao:${BackendVersions.exposed}"
    const val exposedJdbc = "$exposedDependenciesPrefix:exposed-jdbc:${BackendVersions.exposed}"

    // Working with database
    const val hikariCP = "com.zaxxer:HikariCP:${BackendVersions.hikariCP}"
    const val postgresql = "org.postgresql:postgresql:${BackendVersions.postgresql}"

}

object BackendVersions {
    const val logback = "1.2.10"
    const val kotlinHtmlJvm = "0.7.3"
    const val kotlinCssJvm = "1.0.0-pre.264-kotlin-1.5.31"
    const val exposed = "0.37.3"
    const val hikariCP = "5.0.1"
    const val postgresql = "42.2.2"
}