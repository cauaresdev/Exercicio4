<<<<<<< HEAD
import com.android.build.api.dsl.ViewBinding

=======
>>>>>>> 41199c7cde2fb0380f7882a952d4cc4306637a3f
plugins {
    alias(libs.plugins.android.application)
}

android {
<<<<<<< HEAD
    namespace = "com.cauarosa.navegabilidadeentreastelas"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.cauarosa.navegabilidadeentreastelas"
=======
    namespace = "com.example.exercicio4"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.example.exercicio4"
>>>>>>> 41199c7cde2fb0380f7882a952d4cc4306637a3f
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
<<<<<<< HEAD
=======
        viewBinding {
            enable = true
        }
>>>>>>> 41199c7cde2fb0380f7882a952d4cc4306637a3f
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
<<<<<<< HEAD
    viewBinding {
        enable = true
    }
=======
>>>>>>> 41199c7cde2fb0380f7882a952d4cc4306637a3f
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}