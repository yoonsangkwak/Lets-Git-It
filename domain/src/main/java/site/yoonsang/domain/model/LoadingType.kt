package site.yoonsang.domain.model

sealed class LoadingType {
    object NormalLoading : LoadingType()
    object DimLoading : LoadingType()
    object NotLoading : LoadingType()
}