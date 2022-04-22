// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    `kotlin-dsl`
}




buildscript {
    repositories {
        mavenCentral()

    }
    dependencies {
        classpath ("com.android.tools.build:gradle:7.1.0")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
        classpath ("io.insert-koin:koin-gradle-plugin:2.2.3")

    }
}

