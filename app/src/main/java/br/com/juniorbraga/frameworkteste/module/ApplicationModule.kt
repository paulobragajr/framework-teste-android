package br.com.juniorbraga.frameworkteste.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 *
 * @project Framework Teste
 * @author juniorbraga on 14/08/21.
 *
 **/
@Module
class ApplicationModule {

    private var application: Application

    constructor(application: Application) {
        this.application = application
    }

    @Provides
    @Singleton
    fun provideContext(): Context {
        return application
    }
}