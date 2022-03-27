package site.yoonsang.data.datasource.remote

import site.yoonsang.data.api.GithubService
import site.yoonsang.data.mapper.mapToSearchedRepos
import site.yoonsang.domain.model.SearchedRepos
import javax.inject.Inject

class GithubRemoteSourceImpl @Inject constructor(
    private val githubService: GithubService
): GithubRemoteSource {

    override suspend fun getSearchedRepos(query: String, page: Int): SearchedRepos {
        return githubService.getSearchedRepos(query = query, page = page).mapToSearchedRepos()
    }
}