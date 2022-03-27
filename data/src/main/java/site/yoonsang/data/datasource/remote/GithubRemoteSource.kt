package site.yoonsang.data.datasource.remote

import site.yoonsang.domain.model.SearchedRepos

interface GithubRemoteSource {

    suspend fun getSearchedRepos(query: String, page: Int): SearchedRepos
}