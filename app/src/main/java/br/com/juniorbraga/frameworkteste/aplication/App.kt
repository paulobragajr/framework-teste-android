package br.com.juniorbraga.frameworkteste.aplication

import android.app.Application
import androidx.room.Room
import br.com.juniorbraga.frameworkteste.module.APIModuleService
import br.com.juniorbraga.frameworkteste.module.ApplicationModule
import br.com.juniorbraga.frameworkteste.module.MainModule
import com.facebook.stetho.Stetho

/**
 *
 * @project Framework Teste
 * @author juniorbraga on 14/08/21.
 *
 **/
class App : Application() {

    private lateinit var component: ApplicationComponent

    companion object {
        var database: AppDataBase? = null
    }

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .aPIModuleService(APIModuleService())
            .mainModule(MainModule())
            .build()

        //Room
        database = Room.databaseBuilder(this, AppDataBase::class.java, "framework-data").allowMainThreadQueries().build()

        //Stetho
        val initializerBuilder = Stetho.newInitializerBuilder(this)
        initializerBuilder.enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
        val initializer = initializerBuilder.build()
        Stetho.initialize(initializer)

    }

    fun getComponent(): ApplicationComponent {
        return component
    }
}