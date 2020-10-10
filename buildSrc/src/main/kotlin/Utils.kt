import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

/**
 * Created on 2020/10/10.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */

/**
 * As android library.
 */
fun Project.asAndroidLib() {
    apply { plugin("com.android.library") }
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
 * Get versionCode By versionName.
 *
 * @param versionName versionName
 */
fun getVersionCodeByName(versionName: String?): Int {
    if (versionName == null) return 0
    val array = versionName.split(".").toList()
    val major = if (array.isNotEmpty()) array[0].toInt() else 0
    val minor = if (array.size > 1) array[1].toInt() else 0
    val release = if (array.size > 2) array[2].toInt() else 0
    val code = major * 1000000 + minor * 1000 + release
    println("VersionCode: $code")
    return code
}

/**
 * Get Prefix by tag.
 *
 * @param tag Module Tag
 */
fun getPrefix(tag: String?): String {
    return if (tag == null) "" else tag + "_"
}

/**
 * Is run alone by tag.
 */
fun isRunAlone(tag: String?): Boolean {
    return Module.values().find { it.tag == tag }?.runAlone ?: false
}

/**
 * Get application id by tag.
 */
fun getApplicationId(tag: String?): String {
    return AppConfig.applicationIdPre + (tag ?: "xxx")
}

fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? =
    add("implementation", dependencyNotation)

fun DependencyHandler.testImplementation(dependencyNotation: Any): Dependency? =
    add("testImplementation", dependencyNotation)

fun DependencyHandler.androidTestImplementation(dependencyNotation: Any): Dependency? =
    add("androidTestImplementation", dependencyNotation)

fun DependencyHandler.api(dependencyNotation: Any): Dependency? =
    add("api", dependencyNotation)

fun DependencyHandler.kapt(dependencyNotation: Any): Dependency? =
    add("kapt", dependencyNotation)