
plugins {
    id("com.android.library")

    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("myDependencies")
    id("myBuildConfig")


}

android {
    compileSdkVersion(Android.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdkVersion(Android.MIN_SDK_VERSION)
        targetSdkVersion(Android.TARGET_SDK_VERSION)
        vectorDrawables.useSupportLibrary = true
        multiDexEnabled = true

    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
    @Suppress("UnstableApiUsage")
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    api(LibDependency.COROUTINES_ANDROID)
    api(LibDependency.COROUTINES)
    implementation (LibDependency.CORE_KTX)



    api(LibDependency.KOIN)
    api(LibDependency.KOIN_SCOPE)
    api(LibDependency.KOIN_VIEWMODEL)

    api(LibDependency.LIFECYCLE_VIEWMODEL){
        isForce= true
    }
    api(LibDependency.LIFECYCLE_EXTENSIONS){
        isForce=true
    }
    api(LibDependency.LIFECYCLE_PROCESS){
        isForce=true
    }
    api(LibDependency.LIFE_CYCLES_RUN_TIME)

    api(LibDependency.ROOM)
    api(LibDependency.ROOM_KTX)
    api(LibDependency.ROOM_RX)

    api (LibDependency.RETROFIT_CONVERTER)
    api (LibDependency.OKHTTP){
        isForce = true
    }
    debugApi (LibDependency.LOGGING)
    api (LibDependency.RETROFIT)
    api (LibDependency.RETROFIT_RX_CONVERTER)

    implementation (LibDependency.CONSTRAINT_LAYOUT)
    implementation (LibDependency.GSON)
    implementation (LibDependency.GLIDE)
    implementation (LibDependency.PAGING_COMMON)
    implementation (LibDependency.PAGING_RUN_TIME)
    implementation (LibDependency.MATERIAL)
    implementation (LibDependency.APP_COMPAT)


    api(LibDependency.FRAGMENT_KTX)
    api(LibDependency.NAVIGATION_FRAGMENT_KTX)
    api(LibDependency.NAVIGATION_UI_KTX)
    api(LibDependency.NAVIGATION_DYNAMIC)

}
