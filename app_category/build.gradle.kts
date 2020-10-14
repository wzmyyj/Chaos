plugins { if (Module.Category.runAlone) id(Android.application) else id(Android.library) }
setupAssembly(Module.Category)