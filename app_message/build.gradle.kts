plugins { if (Module.Message.runAlone) id(Android.application) else id(Android.library) }
setupAssembly(Module.Message)