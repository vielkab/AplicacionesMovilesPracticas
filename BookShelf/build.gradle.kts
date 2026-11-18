import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
}

// Leer las propiedades locales del proyecto
val localProperties = Properties()
val localPropertiesFile = rootProject.file("local.properties")

if (localPropertiesFile.exists()) {
    localPropertiesFile.inputStream().use {
        localProperties.load(it)
    }
}

val booksApiKey = localProperties.getProperty("BOOKS_API_KEY") ?: ""

android {
    namespace = "com.apps.bookshelf"

    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.apps.bookshelf"
        minSdk = 35
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        // Exponer la clave mediante BuildConfig
        buildConfigField(
            "String",
            "BOOKS_API_KEY",
            "\"$booksApiKey\""
        )

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // Retrofit
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.gson)

    // Carga de imágenes
    implementation(libs.coil.compose)

    // ViewModel para Jetpack Compose
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    // Corrutinas asociadas al ciclo de vida del ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    // Observar estados del ViewModel desde Compose
    implementation(libs.androidx.lifecycle.runtime.compose)

    testImplementation(libs.junit)
    testImplementation(libs.kotlinx.coroutines.test)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)
}
