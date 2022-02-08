plugins {
    application
    kotlin("jvm")
    kotlin(Plugins.kotlinSerialization)
}

repositories {
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap") }
    maven { url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-js-wrappers") }
}

dependencies {
    implementation(project(":shared"))
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
        implementation(ktorCors)
        implementation(ktorHtmlBuilder)
        implementation(SharedDeps.ktorSerializationJson)
        implementation(ktorServerWebsocket)
        implementation(ktorNetty)
        implementation(logbackClassic)

        implementation(kotlinHtmlJvm)
        implementation(kotlinCssJvm)

        implementation(exposedCore)
        implementation(exposedDao)
        implementation(exposedJdbc)

        implementation(hikariCP)
        implementation(postgresql)

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
