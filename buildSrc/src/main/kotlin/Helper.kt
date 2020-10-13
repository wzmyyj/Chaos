import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByName
import org.jetbrains.kotlin.gradle.plugin.KaptExtension

/**
 * Created on 2020/10/10.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
private val Project.android_ get() = extensions.getByName<BaseExtension>("android")
private val Project.kapt_ get() = extensions.getByName<KaptExtension>("kapt")

/**
 * Do core gradle config.
 */
fun Project.setupCore() {
    android_.apply {
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
        fileTree(mapOf("dir" to "libs", "include" to arrayOf("*.jar", "*.aar")))
        implementation2(Dependencies.androidx_appcompat)
        testImplementation2(Dependencies.junit)
        androidTestImplementation2(Dependencies.test_junit)
        androidTestImplementation2(Dependencies.test_espresso)
    }
}

/**
 * Do common gradle config.
 */
fun Project.setupCommon(module: Module) {
    useKotlin()
    setupCore()
    android_.apply {
        resourcePrefix(getPrefix(module.tag))
        @Suppress("UnstableApiUsage")
        buildFeatures.dataBinding = true
        defaultConfig.multiDexEnabled = true
    }
    dependencies {
        implementation2(Dependencies.androidx_coreKtx)
        implementation2(Dependencies.androidx_constraintlayout)
        implementation2(Dependencies.androidx_recyclerview)
        implementation2(Dependencies.androidx_lifecycle_ext)
        implementation2(Dependencies.kotlin_jdk)
        api2(project(":lib_base"))
        api2(project(":lib_utils"))
    }
}

/**
 * Do common service gradle config.
 */
fun Project.setupCommonService(module: Module) {
    useKotlin()
    setupCore()
    android_.apply {
        resourcePrefix(getPrefix(module.tag))
    }
    dependencies {
        implementation2(Dependencies.androidx_coreKtx)
        implementation2(Dependencies.kotlin_jdk)
        api2(project(":lib_base"))
        api2(project(":lib_utils"))
    }
}

/**
 * Do assembly gradle config.
 */
fun Project.setupAssembly(module: Module) {
    setupCommon(module)
    useARouter()
    android_.apply {
        val runAlone = module.runAlone
        if (runAlone) {
            defaultConfig.applicationId = getApplicationId(module.tag)
        }
        sourceSets {
            getByName("main") {
                // 单独调试与集成调试时使用不同的 AndroidManifest.xml 文件
                if (runAlone) {
                    manifest.srcFile("src/main/run_alone/AndroidManifest.xml")
                } else {
                    manifest.srcFile("src/main/AndroidManifest.xml")
                    java.exclude("src/main/run_alone/*")
                }
            }
        }
    }
    dependencies {
        api2(project(":common"))
        api2(project(":common_service"))
    }
}

/**
 * Do app gradle config.
 */
fun Project.setupApp(module: Module) {
    setupCommon(module)
    useARouter()
    android_.apply {
        defaultConfig.applicationId = getApplicationId(module.tag)
        flavorDimensions("channel")
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
        api2(project(":common"))
        api2(project(":common_service"))
    }
}

/**
 * use kotlin in this module.
 */
fun Project.useKotlin() {
    apply {
        plugin("kotlin-android")
        plugin("kotlin-android-extensions")
        plugin("kotlin-kapt")
    }
}

/**
 * use ARouter.
 */
fun Project.useARouter() {
    kapt_.apply {
        arguments {
            arg("AROUTER_MODULE_NAME", project.name)
        }
    }
    dependencies {
        kapt2(Dependencies.arouter_compiler)
        implementation2(Dependencies.arouter_api)
    }
}



