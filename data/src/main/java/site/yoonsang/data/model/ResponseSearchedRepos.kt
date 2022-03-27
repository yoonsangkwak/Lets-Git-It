package site.yoonsang.data.model

import com.google.gson.annotations.SerializedName

data class ResponseSearchedRepos(
    @SerializedName("incomplete_results") val incompleteResults: Boolean? = null,
    @SerializedName("items") val items: List<ResponseRepoInfo>? = null,
    @SerializedName("total_count") val totalCount: Int? = null
)