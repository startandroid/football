plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "ru.startandroid.teams"
    compileSdk = 34
}

dependencies {
    api(project(":features:teams:api"))
    implementation(project(":features:teams:view"))
    implementation(project(":features:teams:data"))

}