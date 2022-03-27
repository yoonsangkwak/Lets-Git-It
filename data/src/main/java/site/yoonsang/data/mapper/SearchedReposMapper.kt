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
        repoInfos = this.items?.mapToRepoInfo() ?: emptyList(),
        totalCount = this.totalCount ?: 0
    )
}

fun List<ResponseRepoInfo>.mapToRepoInfo(): List<RepoInfo> {
    var repoInfoList = listOf<RepoInfo>()
    this.forEach {
        repoInfoList = repoInfoList.plus(
            RepoInfo(
                description = it.description ?: "",
                forksCount = it.forksCount ?: 0,
                full_name = it.fullName ?: "",
                htmlUrl = it.htmlUrl ?: "",
                id = it.id ?: 0,
                language = it.language ?: "",
                license = it.license?.mapToRepoLicense(),
                name = it.name ?: "",
                owner = it.owner?.mapToRepoOwner(),
                isPrivate = it.isPrivate ?: false,
                stargazersCount = it.stargazersCount ?: 0
            )
        )
    }
    return repoInfoList
}

fun ResponseRepoLicense.mapToRepoLicense(): RepoLicense {
    return RepoLicense(
        key = this.key ?: "",
        name = this.name ?: ""
    )
}

fun ResponseRepoOwner.mapToRepoOwner(): RepoOwner {
    return RepoOwner(
        avatarUrl = this.avatarUrl ?: "",
        htmlUrl = this.htmlUrl ?: "",
        id = this.id ?: 0,
        login = this.login ?: "",
        type = this.type ?: ""
    )
}