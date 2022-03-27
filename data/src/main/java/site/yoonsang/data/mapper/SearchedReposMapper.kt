package site.yoonsang.data.mapper

import site.yoonsang.data.model.ResponseRepoInfo
import site.yoonsang.data.model.ResponseRepoLicense
import site.yoonsang.data.model.ResponseRepoOwner
import site.yoonsang.data.model.ResponseSearchedRepos
import site.yoonsang.domain.model.RepoInfo
import site.yoonsang.domain.model.RepoLicense
import site.yoonsang.domain.model.RepoOwner
import site.yoonsang.domain.model.SearchedRepos

fun ResponseSearchedRepos.mapToSearchedRepos(): SearchedRepos {
    return SearchedRepos(
        repoInfos = this.items.mapToRepoInfo(),
        totalCount = this.total_count
    )
}

fun List<ResponseRepoInfo>.mapToRepoInfo(): List<RepoInfo> {
    var repoInfoList = listOf<RepoInfo>()
    this.forEach {
        repoInfoList = repoInfoList.plus(
            RepoInfo(
                description = it.description,
                forksCount = it.forks_count,
                full_name = it.full_name,
                htmlUrl = it.html_url,
                id = it.id,
                language = it.language,
                license = it.license.mapToRepoLicense(),
                name = it.name,
                owner = it.owner.mapToRepoOwner(),
                private = it.private,
                stargazersCount = it.stargazers_count
            )
        )
    }
    return repoInfoList
}

fun ResponseRepoLicense.mapToRepoLicense(): RepoLicense {
    return RepoLicense(
        key = this.key,
        name = this.name
    )
}

fun ResponseRepoOwner.mapToRepoOwner(): RepoOwner {
    return RepoOwner(
        avatarUrl = this.avatar_url,
        htmlUrl = this.html_url,
        id = this.id,
        login = this.login,
        type = this.type
    )
}