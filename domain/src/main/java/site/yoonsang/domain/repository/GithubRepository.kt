package site.yoonsang.domain.repository

import site.yoonsang.domain.model.SearchedRepos

interface GithubRepository {

    suspend fun getSearchedRepos(query: String, page: Int): SearchedRepos
}