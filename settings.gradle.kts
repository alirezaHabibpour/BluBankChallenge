pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "blueBank"
include(":app", ":common")
includeBuild("DependenciesPlugin")
includeBuild("BuildConfigPlugin")
include( ":features:creditCard")

