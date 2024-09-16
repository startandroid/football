plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "ru.startandroid.standings"
    compileSdk = 34
}

dependencies {
    api(project(":features:standings:api"))
    implementation(project(":features:standings:view"))
    implementation(project(":features:standings:data"))

}