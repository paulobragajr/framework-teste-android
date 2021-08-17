package br.com.juniorbraga.frameworkteste.module

import br.com.juniorbraga.frameworkteste.service.BASE_URL
import br.com.juniorbraga.frameworkteste.service.EndPoint
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 *
 * @project Framework Teste
 * @author juniorbraga on 14/08/21.
 *
 **/
@Module
class APIModuleService {

    @Provides
    fun provideClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Provides
    fun provideRetrofit(baseUrl: String, client: OkHttpClient): Retrofit {

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    fun provideAPIService(): EndPoint {
        return provideRetrofit(BASE_URL, provideClient()).create(EndPoint::class.java)
    }

}