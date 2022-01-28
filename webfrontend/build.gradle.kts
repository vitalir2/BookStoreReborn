plugins {
    id("org.jetbrains.kotlin.js")
}

repositories {
    mavenCentral()
}

dependencies {
    with(WebFrontendDeps) {
        implementation(kotlin(kotlinJs))

        implementation(reactCore)
        implementation(reactDom)
        implementation(reactRouter)
        implementation(reactRedux)

        implementation(redux)

        implementation(styled)
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