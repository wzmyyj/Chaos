plugins { id(Android.application) }
setupApp(Module.App)
dependModules(
    Module.Login,
    Module.Main,
    Module.Home,
    Module.Message,
    Module.Category,
    Module.Track,
    Module.Mine
)