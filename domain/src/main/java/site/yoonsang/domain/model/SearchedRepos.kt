package site.yoonsang.domain.model

data class SearchedRepos(
    val repoInfos: List<RepoInfo>,
    val totalCount: Int
)
