package site.yoonsang.letsgitit.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import site.yoonsang.data.datasource.remote.GithubRemoteSource
import site.yoonsang.data.repository.GithubRepositoryImpl
import site.yoonsang.domain.repository.GithubRepository

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideGithubRepository(githubRemoteSource: GithubRemoteSource): GithubRepository {
        return GithubRepositoryImpl(githubRemoteSource)
    }
}