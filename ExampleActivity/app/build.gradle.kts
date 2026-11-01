plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.exampleactivity"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.exampleactivity"
        minSdk = 31
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    /*
    For fragment dependency
     */
    val fragment_version = "1.8.1"
    // Java language implementation
    implementation("androidx.fragment:fragment:$fragment_version")
    // Kotlin language implementation
    implementation("androidx.fragment:fragment-ktx:$fragment_version")

    /*
    For appcompat dependency
    */
    val appcompat_version = "1.7.0"
    // Java language implementation
    implementation("androidx.appcompat:appcompat:$appcompat_version")
    // Kotlin language implementation
    //implementation("androidx.appcompat:appcompat-ktx:$appcompat_version")

    // For loading and tinting drawables on older versions of the platform
    implementation("androidx.appcompat:appcompat-resources:$appcompat_version")

}