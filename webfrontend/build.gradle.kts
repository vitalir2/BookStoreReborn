plugins {
    kotlin("js")
    kotlin(Plugins.kotlinSerialization)
    id(Plugins.kotlinJsLegacyUnion) version PluginsVersion.kotlinJsLegacyUnion
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":shared"))

    with(WebFrontendDeps) {
        implementation(kotlin(kotlinJs))

        implementation(enforcedPlatform(kotlinWrapperBom))

        implementation(reactCore)
        implementation(reactDom)
        implementation(emotion)
        implementation(reactRouter)
        implementation(reactRedux)

        implementation(redux)

        implementation(styled)
        implementation(kotlinMui)
        implementation(kotlinMuiIcons)

        implementation(SharedDeps.ktorClientCore)
        implementation(SharedDeps.ktorClientLogging)
        implementation(ktorClientJs)

        implementation(SharedDeps.kotlinCoroutines)
        implementation(kotlinCoroutinesJs)
        implementation(SharedDeps.kotlinSerializationJson)
        implementation(SharedDeps.ktorClientContentNegotiation)
        implementation(SharedDeps.ktorSerializationJson)

        implementation(npm("react-material-ui-carousel", "3.3.3"))
    }
}

kotlin {
    js {
        browser {
            webpackTask {
                cssSupport.enabled = true
            }

            runTask {
                cssSupport.enabled = true
            }

            testTask {
                useKarma {
                    useChromeHeadless()
                    webpackConfig.cssSupport.enabled = true
                }
            }
        }
        binaries.executable()
    }
}
