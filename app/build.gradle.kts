plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlinx-serialization")
}

android {
    compileSdk = 31
    defaultConfig {
        applicationId = "com.allen.simplejson"
        minSdk = 26
        targetSdk = 31
        versionCode = 2
        versionName = "1.2"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
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
    buildFeatures { compose = true }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.4"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    val composerversion = "1.0.4"
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.compose.ui:ui:$composerversion")
    implementation("androidx.compose.material:material:$composerversion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composerversion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")
    implementation("androidx.activity:activity-compose:1.4.0")
    testImplementation("junit:junit:4.+")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composerversion")
    debugImplementation("androidx.compose.ui:ui-tooling:$composerversion")

    //Navigation
    implementation("androidx.navigation:navigation-compose:2.4.0-beta02")

    //coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")

    //Ktor client
    val ktorver = "1.6.4"
    implementation("io.ktor:ktor-client-core:$ktorver")
    implementation("io.ktor:ktor-client-android:$ktorver")
    implementation("io.ktor:ktor-client-serialization:$ktorver")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0")

    //accompanist
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.21.0-beta")

    //LiveData
    implementation("androidx.compose.runtime:runtime-livedata:$composerversion")

}