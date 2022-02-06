object SharedDeps {
    const val kotlinMultiplatform = "multiplatform"
    const val kotlinTest = "test"
    const val kotlinSerializationJson =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${SharedVersions.kotlinSerialization}"
    const val ktorClientCore = "io.ktor:ktor-client-core:${SharedVersions.ktor}"
    const val ktorClientLogging = "io.ktor:ktor-client-logging:${SharedVersions.ktor}"
    const val ktorClientContentNegotiation = "io.ktor:ktor-client-content-negotiation:${SharedVersions.ktor}"
    const val ktorSerializationJson = "io.ktor:ktor-serialization-kotlinx-json:${SharedVersions.ktor}"
    const val kotlinCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${SharedVersions.kotlinCoroutines}"
}

object SharedVersions {
    const val kotlin = "1.6.10"
    const val kotlinSerialization = "1.3.2"
    const val ktor = "2.0.0-beta-1"
    const val kotlinCoroutines = "1.6.0"
}