package site.yoonsang.letsgitit.di

import com.orhanobut.logger.Logger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import site.yoonsang.letsgitit.BuildConfig
import site.yoonsang.letsgitit.constants.CONNECT_TIMEOUT
import site.yoonsang.letsgitit.constants.GITHUB_BASE_URL
import site.yoonsang.letsgitit.constants.READ_TIMEOUT
import site.yoonsang.letsgitit.constants.WRITE_TIMEOUT
import site.yoonsang.letsgitit.network.GithubApi
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class Github

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val logger = HttpLoggingInterceptor.Logger { Logger.i(it) }
        return HttpLoggingInterceptor(logger).apply {
            level = when (BuildConfig.DEBUG) {
                true -> HttpLoggingInterceptor.Level.BODY
                false -> HttpLoggingInterceptor.Level.NONE
            }
        }
    }

    @Github
    @Singleton
    @Provides
    fun provideOkhttpClient(logger: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().apply {
            connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            retryOnConnectionFailure(true)
            addInterceptor(logger)
        }.build()
    }

    @Github
    @Singleton
    @Provides
    fun provideRetrofit(@Github okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(GITHUB_BASE_URL)
            .client(okHttpClient)
            .build()
    }

    @Github
    @Singleton
    @Provides
    fun provideGithubService(@Github retrofit: Retrofit): GithubApi =
        retrofit.create(GithubApi::class.java)
}