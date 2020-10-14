plugins { if (Module.Track.runAlone) id(Android.application) else id(Android.library) }
setupAssembly(Module.Track)