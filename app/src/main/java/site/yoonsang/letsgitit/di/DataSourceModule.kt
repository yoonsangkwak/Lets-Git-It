package site.yoonsang.letsgitit.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import site.yoonsang.data.api.GithubService
import site.yoonsang.data.datasource.remote.GithubRemoteSource
import site.yoonsang.data.datasource.remote.GithubRemoteSourceImpl

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    fun provideGithubRemoteDataSource(githubService: GithubService): GithubRemoteSource {
        return GithubRemoteSourceImpl(githubService)
    }
}