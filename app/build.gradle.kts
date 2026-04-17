import java.util.Properties
import java.io.FileInputStream

plugins {
    id("com.android.application")
}

android {
    namespace = "ohi.andre.consolelauncher"
    compileSdk = 35

    val keystorePropertiesFile = rootProject.file("local.properties")
    val keystoreProperties = Properties()
    if (keystorePropertiesFile.exists()) {
        keystoreProperties.load(FileInputStream(keystorePropertiesFile))
    }

    signingConfigs {
        create("release") {
            storeFile = file("../" + (keystoreProperties["storeFile"] ?: "release.jks"))
            storePassword = keystoreProperties["storePassword"]?.toString() ?: ""
            keyAlias = keystoreProperties["keyAlias"]?.toString() ?: "tui-alias"
            keyPassword = keystoreProperties["keyPassword"]?.toString() ?: ""
        }
    }

    defaultConfig {
        applicationId = "ohi.andre.consolelauncher"
        minSdk = 21
        targetSdk = 35
        versionCode = 301
        versionName = "v6.15.1-updated-v2"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    
    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        getByName("debug") {
            signingConfig = signingConfigs.getByName("release")
        }
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("release")
        }
    }

    flavorDimensions.add("default")
    
    productFlavors {
        create("fdroid") {
            dimension = "default"
        }
        create("playstore") {
            dimension = "default"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    lint {
        checkReleaseBuilds = false
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.localbroadcastmanager:localbroadcastmanager:1.1.0")
    
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("net.sourceforge.htmlcleaner:htmlcleaner:2.29")
    implementation("com.jayway.jsonpath:json-path:2.9.0")
    implementation("org.jsoup:jsoup:1.17.2")
    implementation("it.andreuzzi:CompareString2:1.0.9")
}
