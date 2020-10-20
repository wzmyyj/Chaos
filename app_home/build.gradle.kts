plugins { if (Module.Home.runAlone) id(Android.application) else id(Android.library) }
setupAssembly(Module.Home)
dependencies {
    implementation(Dependencies.banner)
}