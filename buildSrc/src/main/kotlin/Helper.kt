import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByName

/**
 * Created on 2020/10/10.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
private val Project.android get() = extensions.getByName<BaseExtension>("android")

/**
 * Do core gradle config.
 */
fun Project.setupCore() {
    android.apply {
        compileSdkVersion(AndroidConfig.compileSdkVersion)
        buildToolsVersion(AndroidConfig.buildToolsVersion)
        defaultConfig {
            minSdkVersion(AndroidConfig.minSdkVersion)
            targetSdkVersion(AndroidConfig.targetSdkVersion)
            versionCode = getVersionCodeByName(AppConfig.versionName)
            versionName = AppConfig.versionName
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            consumerProguardFiles("consumer-rules.pro")
        }
        buildTypes {
            getByName("release") {
                isMinifyEnabled = false
                proguardFiles(
                    getDefaultProguardFile("proguard-android.txt"),
                    "proguard-rules.pro"
                )
            }
        }
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
    }

    dependencies {
        implementation(Dependencies.androidx_appcompat)
        testImplementation(Dependencies.junit)
        androidTestImplementation(Dependencies.test_junit)
        androidTestImplementation(Dependencies.test_espresso)
    }
}

/**
 * Do common gradle config.
 */
fun Project.setupCommon(tag: String? = null) {
    setupCore()
    android.apply {
        if (tag != null) resourcePrefix(getPrefix(tag))
        @Suppress("DEPRECATION")
        dataBinding.isEnabled = true
        defaultConfig.multiDexEnabled = true
    }
    dependencies {
        implementation(Dependencies.androidx_coreKtx)
        implementation(Dependencies.androidx_constraintlayout)
        implementation(Dependencies.androidx_recyclerview)
        implementation(Dependencies.arouter_api)
        kapt(Dependencies.arouter_compiler)
        api(project(":lib_base"))
        api(project(":lib_utils"))
    }
}

/**
 * Do assembly gradle config.
 */
fun Project.setupAssembly(tag: String? = null) {
    setupCommon(tag)
    android.apply {
        val runAlone = isRunAlone(tag)
        if (runAlone) {
            defaultConfig.applicationId = getApplicationId(tag)
        }
        sourceSets {
            register("main") {
                // 单独调试与集成调试时使用不同的 AndroidManifest.xml 文件
                if (runAlone) {
                    manifest.srcFile("src/main/run_alone/AndroidManifest.xml")
                } else {
                    manifest.srcFile("src/main/AndroidManifest.xml")
                    java.exclude("src/main/run_alone/*")
                }
            }
        }
        productFlavors {
//            // 日常测试
//            daily {}
//            // 灰度
//            gray {}
//            // 官方渠道
//            official {}
        }
    }
    dependencies {
        api(project(":common"))
        api(project(":common_service"))
    }
}

