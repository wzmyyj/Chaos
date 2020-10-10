plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

val tag = "app"

android {

    resourcePrefix(getPrefix(tag))

    compileSdkVersion(AndroidConfig.compileSdkVersion)
    buildToolsVersion(AndroidConfig.buildToolsVersion)

    defaultConfig {
        applicationId = "top.wzmyyj.chaos"
        minSdkVersion(AndroidConfig.minSdkVersion)
        targetSdkVersion(AndroidConfig.targetSdkVersion)
        versionCode = getVersionCodeByName(AppConfig.versionName)
        versionName = AppConfig.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
        multiDexEnabled = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(Dependencies.androidx_appcompat)
    implementation(Dependencies.androidx_coreKtx)
    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.test_junit)
    androidTestImplementation(Dependencies.test_espresso)
    implementation(Dependencies.androidx_constraintlayout)
    implementation(Dependencies.androidx_recyclerview)
}


fun com.android.build.gradle.internal.dsl.DefaultConfig.def(){
    minSdkVersion(AndroidConfig.minSdkVersion)
    targetSdkVersion(AndroidConfig.targetSdkVersion)
    versionCode = getVersionCodeByName(AppConfig.versionName)
    versionName = AppConfig.versionName
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")
    multiDexEnabled = true
}