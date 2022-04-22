plugins {
    `kotlin-dsl`
}


repositories {
    mavenCentral()
}
dependencies {
    implementation("org.jetbrains.kotlin:kotlin-script-runtime:1.6.10")

}
gradlePlugin {
    plugins.register("dependencies") {
        id = "myDependencies"
        implementationClass = "Deps"
    }
}