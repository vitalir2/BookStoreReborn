import BackendVersions.ktorCore

object BackendDeps {
    const val ktorNetty = "io.ktor:ktor-server-netty:${BackendVersions.ktorCore}"
    const val logbackClassic = "ch.qos.logback:logback-classic:${BackendVersions.logback}"
    const val ktorHtmlBuilder = "io.ktor:ktor-server-html-builder:${BackendVersions.ktorCore}"
    const val kotlinHtmlJvm = "org.jetbrains.kotlinx:kotlinx-html-jvm:${BackendVersions.kotlinHtmlJvm}"
    const val ktorServerCore = "io.ktor:ktor-server-core:${BackendVersions.ktorCore}"
    const val ktorAuth = "io.ktor:ktor-server-auth:${BackendVersions.ktorCore}"
    const val ktorLocations = "io.ktor:ktor-server-locations:${BackendVersions.ktorCore}"
    const val ktorClientCore = "io.ktor:ktor-client-core:${BackendVersions.ktorCore}"
    const val ktorClientJvm = "io.ktor:ktor-client-core-jvm:${BackendVersions.ktorCore}"
    const val ktorClientApache = "io.ktor:ktor-client-apache:${BackendVersions.ktorCore}"
    const val ktorSessions = "io.ktor:ktor-server-sessions:${BackendVersions.ktorCore}"
    const val ktorAutoHeadResponse = "io.ktor:ktor-server-auto-head-response:${BackendVersions.ktorCore}"
    const val ktorServerHostCommon = "io.ktor:ktor-server-host-common:${BackendVersions.ktorCore}"
    const val ktorStatusPages = "io.ktor:ktor-server-status-pages:${BackendVersions.ktorCore}"
    const val ktorCachingHeaders = "io.ktor:ktor-server-caching-headers:${BackendVersions.ktorCore}"
    const val ktorCompression = "io.ktor:ktor-server-compression:${BackendVersions.ktorCore}"
    const val ktorConditionalHeaders = "io.ktor:ktor-server-conditional-headers:${BackendVersions.ktorCore}"
    const val ktorContentNegotiation = "io.ktor:ktor-server-content-negotiation:${BackendVersions.ktorCore}"
    const val ktorDefaultHeaders = "io.ktor:ktor-server-default-headers:${BackendVersions.ktorCore}"
    const val ktorCallLogging = "io.ktor:ktor-server-call-logging:${BackendVersions.ktorCore}"
    const val kotlinCssJvm = "org.jetbrains.kotlin-wrappers:kotlin-css:${BackendVersions.kotlinCssJvm}"
    const val ktorSerializationJson = "io.ktor:ktor-serialization-kotlinx-json:${BackendVersions.ktorCore}"
    const val ktorServerWebsocket = "io.ktor:ktor-server-websockets:${BackendVersions.ktorCore}"
    const val ktorServerTests = "io.ktor:ktor-server-tests:$ktorCore"
    const val kotlinTestJunit = "org.jetbrains.kotlin:kotlin-test-junit:${SharedVersions.kotlin}"
}

object BackendVersions {
    const val ktorCore = "2.0.0-beta-1"
    const val logback = "1.2.10"
    const val kotlinHtmlJvm = "0.7.2"
    const val kotlinCssJvm = "1.0.0-pre.264-kotlin-1.5.31"
}