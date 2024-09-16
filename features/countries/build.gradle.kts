plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "ru.startandroid.countries"
    compileSdk = 34
}

dependencies {
    api(project(":features:countries:api"))
    implementation(project(":features:countries:view"))
    implementation(project(":features:countries:data"))
}