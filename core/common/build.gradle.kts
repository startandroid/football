plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    alias(libs.plugins.ksp)
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

dependencies {
    implementation(libs.coroutines)

    implementation(libs.hilt.core)
    implementation(libs.serialization)
    ksp(libs.hilt.android.compiler)


}