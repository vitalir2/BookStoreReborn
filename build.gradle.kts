plugins {
    kotlin("multiplatform") version "1.6.10"
    application
}

group = "me.vitalir"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven")
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        withJava()
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    js(IR) {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting {
            dependencies {
                with(BackendDeps) {
                    implementation(ktorNetty)

                    implementation(logbackClassic)

                    implementation(ktorHtmlBuilder)
                    implementation(kotlinHtmlJvm)
                }
            }
        }
        val jvmTest by getting
        val jsMain by getting {
            dependencies {
                with(WebFrontendDeps) {
                    implementation(reactCore)
                    implementation(reactDom)
                    implementation(reactRouter)
                    implementation(reactRedux)

                    implementation(redux)

                    implementation(styled)
                }
            }
        }
        val jsTest by getting
    }
}

application {
    mainClass.set("me.vitalir.application.ServerKt")
}

tasks.named<Copy>("jvmProcessResources") {
    val jsBrowserDistribution = tasks.named("jsBrowserDistribution")
    from(jsBrowserDistribution)
}

tasks.named<JavaExec>("run") {
    dependsOn(tasks.named<Jar>("jvmJar"))
    classpath(tasks.named<Jar>("jvmJar"))
}