plugins { if (Module.Active.runAlone) id(Android.application) else id(Android.library) }
setupAssembly(Module.Active)