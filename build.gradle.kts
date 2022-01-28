buildscript {
    repositories {
        gradlePluginPortal()
        google()
    }
    dependencies {
        classpath(Plugins.kotlinPlugin)
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
