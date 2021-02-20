plugins { if (Module.Main.runAlone) id(Android.application) else id(Android.library) }
setupAssembly(Module.Main)
dependencies{
    api(project(":app_home"))
}