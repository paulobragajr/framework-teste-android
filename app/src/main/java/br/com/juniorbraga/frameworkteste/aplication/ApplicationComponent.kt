package br.com.juniorbraga.frameworkteste.aplication

import br.com.juniorbraga.frameworkteste.ui.main.MainActivity
import br.com.juniorbraga.frameworkteste.module.APIModuleService
import br.com.juniorbraga.frameworkteste.module.ApplicationModule
import br.com.juniorbraga.frameworkteste.module.MainModule
import dagger.Component
import javax.inject.Singleton

/**
 *
 * @project Framework Teste
 * @author juniorbraga on 14/08/21.
 *
 **/
@Singleton
@Component(modules = [ApplicationModule::class, APIModuleService::class, MainModule::class])
interface ApplicationComponent {
    fun inject(activity: MainActivity)
}