package site.yoonsang.domain.model

data class RepoInfo(
    val description: String,
    val forksCount: Int,
    val full_name: String,
    val htmlUrl: String,
    val id: Int,
    val language: String,
    val license: RepoLicense?,
    val name: String,
    val owner: RepoOwner?,
    val isPrivate: Boolean,
    val stargazersCount: Int,
)
