package site.yoonsang.data.model

import com.google.gson.annotations.SerializedName

data class ResponseRepoLicense(
    @SerializedName("key") val key: String? = null,
    @SerializedName("name") val name: String? = null,
)