plugins { if (Module.Mine.runAlone) id(Android.application) else id(Android.library) }
setupAssembly(Module.Mine)