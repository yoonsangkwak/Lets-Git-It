package site.yoonsang.domain.usecase

import site.yoonsang.domain.model.SearchedRepos
import site.yoonsang.domain.repository.GithubRepository
import javax.inject.Inject

class GetSearchedReposUseCase @Inject constructor(private val githubRepository: GithubRepository) {

    suspend operator fun invoke(query: String, page: Int): SearchedRepos {
        return githubRepository.getSearchedRepos(query, page)
    }
}