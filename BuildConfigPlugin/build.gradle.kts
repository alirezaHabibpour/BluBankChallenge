plugins {
    `kotlin-dsl`
}


repositories {
    mavenCentral()
}

gradlePlugin {
    plugins.register("buildConfig") {
        id = "myBuildConfig"
        implementationClass = "BuildConfig"
    }
}