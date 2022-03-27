package site.yoonsang.data.model

import com.google.gson.annotations.SerializedName

data class ResponseRepoOwner(
    @SerializedName("avatar_url") val avatarUrl: String? = null,
    @SerializedName("html_url") val htmlUrl: String? = null,
    @SerializedName("id") val id: Int? = null,
    @SerializedName("login") val login: String? = null,
    @SerializedName("type") val type: String? = null,
)