plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "ru.startandroid.players"
    compileSdk = 34
}

dependencies {
    api(project(":features:players:api"))
    implementation(project(":features:players:view"))
    implementation(project(":features:players:data"))

}