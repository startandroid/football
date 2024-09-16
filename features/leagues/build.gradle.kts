plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "ru.startandroid.leagues"
    compileSdk = 34
}

dependencies {
    api(project(":features:leagues:api"))
    implementation(project(":features:leagues:view"))
    implementation(project(":features:leagues:data"))
}