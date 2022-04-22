import org.gradle.api.Plugin
import org.gradle.api.Project

class Deps : Plugin<Project> {
    override fun apply(target: Project) {

    }

}

object Versions {
    const val constraintLayout = "2.1.3"
    const val kotlin = "1.6.10"
    const val appCompat = "1.4.1"
    const val material = "1.5.0"
    const val PAGING = "2.1.2"
    const val GLIDE = "4.8.0"
    const val GSON = "2.8.9"
    const val LOGGING = "4.9.3"
    const val RETROFIT = "2.9.0"
    const val OKHTTP = "4.9.3"
    const val ROOM = "2.4.1"
    const val LIFECYCLE = "2.4.1"
    const val LIFECYCLE_EXT = "2.2.0"
    const val KOIN = "2.0.1"
    const val COROUTINES = "1.6.0"
    const val GRADLE = "7.0.0-alpha13"
    const val FRAGMENT = "1.2.0-alpha01"
    const val KOTLIN_GRADLE_PLUGIN = "1.6.10"
    const val NAVIGATION = "2.4.2"
    const val calligraphy_version = "3.1.1"




}

object LibDependency {
    const val LIFECYCLE_EXTENSIONS = "androidx.lifecycle:lifecycle-extensions:${Versions.LIFECYCLE_EXT}"
    const val LIFECYCLE_PROCESS = "androidx.lifecycle:lifecycle-process:${Versions.LIFECYCLE}"
    const val LIFECYCLE_VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE}"
    const val LIFE_CYCLES_RUN_TIME = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE}"
    const val ROOM = "androidx.room:room-runtime:${Versions.ROOM}"
    const val ROOM_KTX = "androidx.room:room-ktx:${Versions.ROOM}"
    const val ROOM_RX = "androidx.room:room-rxjava2:${Versions.ROOM}"
    const val ROOM_COMPILER = "androidx.room:room-compiler:${Versions.ROOM}"


    val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    val CORE_KTX = "androidx.core:core-ktx:1.6.0"
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"

    val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val MATERIAL = "com.google.android.material:material:${Versions.material}"
    val PAGING_COMMON = "androidx.paging:paging-common:${Versions.PAGING}"
     val PAGING_RUN_TIME = "androidx.paging:paging-runtime-ktx:${Versions.PAGING}"
     val GLIDE = "com.github.bumptech.glide:glide:${Versions.GLIDE}"
     val GSON = "com.google.code.gson:gson:${Versions.GSON}"
     val LOGGING = "com.squareup.okhttp3:logging-interceptor:${Versions.LOGGING}"
     val RETROFIT_RX_CONVERTER = "com.squareup.retrofit2:adapter-rxjava2:${Versions.RETROFIT}"
     val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
     val RETROFIT_CONVERTER = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
     val OKHTTP = "com.squareup.okhttp3:okhttp:${Versions.OKHTTP}"

    const val KOIN = "io.insert-koin:koin-android:${Versions.KOIN}"
    const val KOIN_VIEWMODEL = "io.insert-koin:koin-android-viewmodel:${Versions.KOIN}"
    const val KOIN_SCOPE = "io.insert-koin:koin-android-scope:${Versions.KOIN}"
    const val KOIN_JAVA = "io.insert-koin:koin-java:${Versions.KOIN}"

    const val GRADLE = "com.android.tools.build:gradle:${Versions.GRADLE}"
    const val KOTLIN_GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN_GRADLE_PLUGIN}"

    const val  FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT}"
    const val NAVIGATION_FRAGMENT = "androidx.navigation:navigation-fragment:${Versions.NAVIGATION}"
    const val NAVIGATION_FRAGMENT_KTX = "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui:${Versions.NAVIGATION}"
    const val NAVIGATION_UI_KTX = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"
    const val NAVIGATION_DYNAMIC = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.NAVIGATION}"
    const val NAVIGATION_RUNTIME = "androidx.navigation:navigation-runtime:${Versions.NAVIGATION}"
    const val NAVIGATION_RUNTIME_KTX = "androidx.navigation:navigation-runtime-ktx:${Versions.NAVIGATION}"

    val CALLIGRAPHY = "io.github.inflationx:calligraphy3:${Versions.calligraphy_version}"

}