plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.buildvarianttest"
    compileSdk {
        version = release(36)
    }



    defaultConfig {
        applicationId = "com.example.buildvarianttest"
        minSdk = 24
        targetSdk = 36
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

    flavorDimensions += "theme"

    productFlavors {
        create("theme-orange") {
            dimension = "theme"
            applicationIdSuffix = ".orange"
            versionNameSuffix = "-orange"
            buildConfigField("Boolean", "IS_ORANGE", "true")
            buildConfigField("String", "COLORCODE", "\"Orange\"")
        }

        create("theme-blue") {
            dimension = "theme"
            applicationIdSuffix = ".blue"
            versionNameSuffix = "-blue"
            buildConfigField("boolean", "IS_BLUE", "true")
            buildConfigField("String", "COLORCODE", "\"Blue\"")
        }

    }

    buildFeatures {
        buildConfig = true
        viewBinding {
            enable = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}