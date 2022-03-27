package site.yoonsang.data.model

data class ResponseSearchedRepos(
    val incomplete_results: Boolean,
    val items: List<ResponseRepoInfo>,
    val total_count: Int
)