import org.gradle.api.Plugin
import org.gradle.api.Project

class BuildConfig : Plugin<Project> {
    override fun apply(target: Project) {

    }

}



object Android {
    const val APPLICATION_ID = "com.blu.bank.challenge.app"
    const val BUILD_TOOLS_VERSION = "29.0.2"
    const val COMPILE_SDK_VERSION = 31
    const val MIN_SDK_VERSION = 21
    const val UTILS_MIN_SDK_VERSION = 14
    const val TARGET_SDK_VERSION = 30


    private const val VERSION_MAJOR = 0
    private const val VERSION_MINOR = 0
    private const val VERSION_PATCH = 1
    const val VERSION_CODE = VERSION_MAJOR * 10000 + VERSION_MINOR * 100 + VERSION_PATCH
    const val VERSION_NAME = "$VERSION_MAJOR.$VERSION_MINOR.$VERSION_PATCH"


}