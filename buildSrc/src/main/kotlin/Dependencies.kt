@file:Suppress("MayBeConstant")

/**
 * Created on 2020/09/19.
 *
 * Dependencies with Versions.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
object Dependencies {

    private object Versions {
        const val build = "4.0.1"
        const val kotlin = "1.4.10"
        const val coreKtx = "1.3.0"
        const val androidx = "1.2.0"
        const val lifecycle = "2.2.0"
        const val fragment = "1.2.5"
        const val room = "2.2.5"
        const val navigation = "2.3.0"
    }

    // gradle
    const val buildGradle = "com.android.tools.build:gradle:${Versions.build}"
    const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

    // kotlin
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    // androidx
    const val androidx_coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val androidx_appcompat = "androidx.appcompat:appcompat:${Versions.androidx}"
    const val androidx_constraintlayout = "androidx.constraintlayout:constraintlayout:1.1.3"
    const val androidx_recyclerview = "androidx.recyclerview:recyclerview:1.1.0-beta03"

    //lifecycle
    const val lifecycle_java8 = "android.arch.lifecycle:common-java8:${Versions.lifecycle}"
    const val lifecycle_ext = "android.arch.lifecycle:extensions:${Versions.lifecycle}"

    //test
    const val junit = "junit:junit:4.12"
    const val test_junit= "androidx.test.ext:junit:1.1.2"
    const val test_espresso = "androidx.test.espresso:espresso-core:3.2.0"


}