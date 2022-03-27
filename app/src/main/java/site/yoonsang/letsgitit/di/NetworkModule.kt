package site.yoonsang.letsgitit.di

import com.orhanobut.logger.Logger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import site.yoonsang.data.api.GithubService
import site.yoonsang.letsgitit.BuildConfig
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    private const val GITHUB_BASE_URL = "https://api.github.com/"
    private const val CONNECT_TIMEOUT = 10L
    private const val WRITE_TIMEOUT = 30L
    private const val READ_TIMEOUT = 30L

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

    @Singleton
    @Provides
    fun provideAcceptHeaderInterceptor(): Interceptor {
        return Interceptor { chain: Interceptor.Chain ->
            val request = chain.request().newBuilder()
                .addHeader("accept", BuildConfig.ACCESS_TOKEN)
                .build()
            chain.proceed(request)
        }
    }

    @Singleton
    @Provides
    fun provideOkhttpClient(logger: HttpLoggingInterceptor, acceptHeader: Interceptor): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addInterceptor(acceptHeader)
            connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            retryOnConnectionFailure(true)
            addInterceptor(logger)
        }.build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(GITHUB_BASE_URL)
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideGithubService(retrofit: Retrofit): GithubService =
        retrofit.create(GithubService::class.java)
}