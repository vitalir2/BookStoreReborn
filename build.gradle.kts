val projectSource = file(rootDir)
val detektConfigFile = files("$rootDir/config/detekt/detekt.yml")
val detektBaselineFile = file("$rootDir/config/detekt/baseline.xml")
val kotlinFiles = "**/*.kt"
val resourceFiles = "**/resources/**"
val buildFiles = "**/build/**"

plugins {
    id("io.gitlab.arturbosch.detekt").version("1.19.0")
}

buildscript {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
    }
    dependencies {
        classpath(Plugins.kotlinPlugin)
        classpath(Plugins.kotlinSerializationClasspath)
    }
}

allprojects {
    repositories {
        mavenCentral()
        google()
    }
}

group = "me.vitalir"
version = "1.0-SNAPSHOT"

dependencies {
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.19.0")
}

tasks.register<io.gitlab.arturbosch.detekt.Detekt>("detektAll") {
    description = "Custom detekt task for all modules"

    parallel = true
    ignoreFailures = false
    buildUponDefaultConfig = true

    setSource(projectSource)
    config.setFrom(detektConfigFile)
    baseline.set(detektBaselineFile)

    include(kotlinFiles)
    exclude(resourceFiles, buildFiles)

    reports {
        html.required.set(true)
    }
}

tasks.register<io.gitlab.arturbosch.detekt.DetektCreateBaselineTask>("detektBaselineAll") {
    description = "Create baseline file for all modules"

    buildUponDefaultConfig.set(true)
    ignoreFailures.set(true)
    parallel.set(true)

    setSource(projectSource)
    config.setFrom(detektConfigFile)
    baseline.set(detektBaselineFile)

    include(kotlinFiles)
    exclude(buildFiles)
    exclude(resourceFiles)
}