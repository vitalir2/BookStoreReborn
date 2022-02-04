val ktor_version = "2.0.0-beta-1"
val kotlin_version = "1.6.10"
val logback_version = "1.2.3"

plugins {
    application
    kotlin("jvm")
    kotlin("plugin.serialization") version "1.6.10"
}

repositories {
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap") }
    maven { url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-js-wrappers") }
}

dependencies {
    with(BackendDeps) {
        implementation(ktorServerCore)
        implementation(ktorAuth)
        implementation(ktorLocations)
        implementation(ktorClientCore)
        implementation(ktorClientJvm)
        implementation(ktorClientApache)
        implementation(ktorSessions)
        implementation(ktorAutoHeadResponse)
        implementation(ktorServerHostCommon)
        implementation(ktorStatusPages)
        implementation(ktorCachingHeaders)
        implementation(ktorCompression)
        implementation(ktorConditionalHeaders)
        implementation(ktorContentNegotiation)
        implementation(ktorDefaultHeaders)
        implementation(ktorCallLogging)
        implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.7.3")
        implementation(ktorHtmlBuilder)
        implementation("org.jetbrains:kotlin-css-jvm:1.0.0-pre.129-kotlin-1.4.20")
        implementation(ktorSerializationJson)
        implementation(ktorServerWebsocket)
        implementation(ktorNetty)
        implementation(logbackClassic)

        testImplementation(ktorServerTests)
        testImplementation(kotlinTestJunit)
    }
}

application {
    mainClass.set("io.ktor.server.netty.EngineMain")
    mainClass.isPresent
}

tasks.named<JavaExec>("run") {
    dependsOn(tasks.named<Jar>("jar"))
    classpath(tasks.named<Jar>("jar"))
}
