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
        const val kotlin = "1.4.10"
        const val coreKtx = "1.3.0"
        const val androidx = "1.2.0"
        const val lifecycle = "2.2.0"
        const val material = "1.2.1"
        const val glide = "4.9.0"
        const val retrofit = "2.4.0"
    }

    // kotlin
    const val kotlin_jdk = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    // androidx
    const val androidx_coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val androidx_appcompat = "androidx.appcompat:appcompat:${Versions.androidx}"
    const val androidx_constraintlayout = "androidx.constraintlayout:constraintlayout:1.1.3"
    const val androidx_recyclerview = "androidx.recyclerview:recyclerview:1.1.0-beta03"
    const val androidx_lifecycle_java8 =
        "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"
    const val androidx_lifecycle_ext =
        "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"

    // material
    const val material = "com.google.android.material:material:${Versions.material}"

    // test
    const val junit = "junit:junit:4.12"
    const val test_junit = "androidx.test.ext:junit:1.1.2"
    const val test_espresso = "androidx.test.espresso:espresso-core:3.2.0"

    // arouter
    const val arouter_api = "com.alibaba:arouter-api:1.4.1"
    const val arouter_compiler = "com.alibaba:arouter-compiler:1.2.2"

    // http
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofit_gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val retrofit_rxJavaAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val okHttp = "com.squareup.okhttp3:okhttp:4.0.1"
    const val okHttp_loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:3.9.0"

    // rx
    const val rx_java = "io.reactivex.rxjava2:rxjava:2.1.12"
    const val rx_android = "io.reactivex.rxjava2:rxandroid:2.1.1"
    const val rx_binding = "com.jakewharton.rxbinding2:rxbinding:2.2.0"

    // glide
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glide_okHttp = "com.github.bumptech.glide:okhttp3-integration:${Versions.glide}"
    const val glide_compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    const val glide_transformation = "jp.wasabeef:glide-transformations:4.0.0"

    // weight
    const val smart_refreshLayout = "com.scwang.smartrefresh:SmartRefreshLayout:1.0.5.1"
    const val banner = "com.youth.banner:banner:1.4.10"

}