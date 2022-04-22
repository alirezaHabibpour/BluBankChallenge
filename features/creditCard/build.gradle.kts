

plugins {
    id("com.android.dynamic-feature")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("myBuildConfig")
    id("myDependencies")


}

android {
    compileSdk = Android.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = Android.MIN_SDK_VERSION
        vectorDrawables.useSupportLibrary = true

    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    dependencies {
        implementation(project(":app"))
        implementation(LibDependency.CALLIGRAPHY)
        kapt(LibDependency.ROOM_COMPILER)

    }




}

