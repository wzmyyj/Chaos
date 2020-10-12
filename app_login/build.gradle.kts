plugins { if (Module.Login.runAlone) id(Android.application) else id(Android.library) }
setupAssembly(Module.Login)