object SharedDeps {
    const val kotlinMultiplatform = "multiplatform"
    const val kotlinTest = "test"
    const val kotlinSerializationJson =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${SharedVersions.kotlinSerialization}"
}

object SharedVersions {
    const val kotlin = "1.6.10"
    const val kotlinSerialization = "1.3.2"
}