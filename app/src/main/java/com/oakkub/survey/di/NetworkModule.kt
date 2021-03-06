package com.oakkub.survey.di

import com.oakkub.survey.BuildConfig
import com.oakkub.survey.common.constants.Endpoints
import com.oakkub.survey.data.services.oauth.OAuthService
import com.oakkub.survey.data.services.surveys.SurveysService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by oakkub on 21/3/2018 AD.
 */
@Module
class NetworkModule {

    @Provides
    fun provideHttpClient(): OkHttpClient = OkHttpClient.Builder()
            .addNetworkInterceptor(HttpLoggingInterceptor().apply {
                if (BuildConfig.DEBUG) {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            })
            .build()

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
            .baseUrl(Endpoints.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    @Provides
    fun provideOAuthService(retrofit: Retrofit): OAuthService = retrofit.create(OAuthService::class.java)

    @Provides
    fun provideSurveysService(retrofit: Retrofit): SurveysService = retrofit.create(SurveysService::class.java)

}
