buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.5.0")
    }
}

tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory)
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
