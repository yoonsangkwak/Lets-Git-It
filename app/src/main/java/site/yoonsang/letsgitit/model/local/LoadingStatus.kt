package site.yoonsang.letsgitit.model.local

sealed class LoadingStatus {
    object ShowNormalLoading : LoadingStatus()
    object ShowDimLoading : LoadingStatus()
    object NotShowLoading : LoadingStatus()
    object HideNormalLoading : LoadingStatus()
    object HideDimLoading : LoadingStatus()
}
