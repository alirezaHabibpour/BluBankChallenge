
plugins {

    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("myBuildConfig")
}

android {
    compileSdk = Android.COMPILE_SDK_VERSION

    defaultConfig {
        applicationId = Android.APPLICATION_ID
        minSdk = Android.MIN_SDK_VERSION
        targetSdk = Android.TARGET_SDK_VERSION
        versionCode = Android.VERSION_CODE
        versionName = Android.VERSION_NAME

        testInstrumentationRunner =  "androidx.test.runner.AndroidJUnitRunner"
    }

    dynamicFeatures.addAll( mutableSetOf(":features:creditCard"))
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles( getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

}

dependencies {

    api(project(":common"))

}