plugins {
    kotlin("js")
}

repositories {
    mavenCentral()
}

dependencies {
    with(WebFrontendDeps) {
        implementation(kotlin(kotlinJs))

        implementation(reactCore)
        implementation(reactDom)
        implementation(reactCss)
        implementation(reactRouter)
        implementation(reactRedux)

        implementation(redux)

        implementation(styled)
        implementation(kotlinMui)
        implementation(kotlinMuiIcons)

        implementation(npm("@emotion/react", "11.7.1"))
        implementation(npm("@emotion/styled", "11.6.0"))

        implementation(npm("@mui/styles", "5.3.0"))
        implementation(npm("react-material-ui-carousel", "3.1.1"))
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