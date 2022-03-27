package site.yoonsang.data.repository

import site.yoonsang.data.datasource.remote.GithubRemoteSource
import site.yoonsang.domain.model.SearchedRepos
import site.yoonsang.domain.repository.GithubRepository
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(
    private val githubRemoteSource: GithubRemoteSource
): GithubRepository {

    override suspend fun getSearchedRepos(query: String, page: Int): SearchedRepos {
        return githubRemoteSource.getSearchedRepos(query, page)
    }
}