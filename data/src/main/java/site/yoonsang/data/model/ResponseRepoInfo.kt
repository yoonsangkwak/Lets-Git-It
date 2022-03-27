package site.yoonsang.data.model

import com.google.gson.annotations.SerializedName

data class ResponseRepoInfo(
    @SerializedName("description") val description: String? = null,
    @SerializedName("forks_count") val forksCount: Int? = null,
    @SerializedName("full_name") val fullName: String? = null,
    @SerializedName("html_url") val htmlUrl: String? = null,
    @SerializedName("id") val id: Int? = null,
    @SerializedName("language") val language: String? = null,
    @SerializedName("license") val license: ResponseRepoLicense? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("owner") val owner: ResponseRepoOwner? = null,
    @SerializedName("private") val isPrivate: Boolean? = null,
    @SerializedName("stargazers_count") val stargazersCount: Int? = null,
)