package site.yoonsang.domain.model

sealed class LoadingStatus {
    object ShowNormalLoading : LoadingStatus()
    object ShowDimLoading : LoadingStatus()
    object NotShowLoading : LoadingStatus()
    object HideNormalLoading : LoadingStatus()
    object HideDimLoading : LoadingStatus()
}
