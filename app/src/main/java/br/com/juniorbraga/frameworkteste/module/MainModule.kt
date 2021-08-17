package br.com.juniorbraga.frameworkteste.module

import br.com.juniorbraga.frameworkteste.service.EndPoint
import br.com.juniorbraga.frameworkteste.ui.main.MainContract
import br.com.juniorbraga.frameworkteste.ui.main.MainModel
import br.com.juniorbraga.frameworkteste.ui.main.MainPresenter
import dagger.Module
import dagger.Provides

/**
 *
 * @project Framework Teste
 * @author juniorbraga on 14/08/21.
 *
 **/

@Module
class MainModule {

    @Provides
    fun provideMainPresenter(model: MainContract.Model): MainContract.Presenter {
        return MainPresenter(model)
    }

    @Provides
    fun provideMainModel(service: EndPoint): MainContract.Model {
        return MainModel(service)
    }
}