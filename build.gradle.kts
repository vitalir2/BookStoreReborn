buildscript {
    repositories {
        gradlePluginPortal()
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
