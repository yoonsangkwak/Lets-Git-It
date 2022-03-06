package site.yoonsang.letsgitit.model.local

sealed class LoadingType {
    object NormalLoading : LoadingType()
    object DimLoading : LoadingType()
    object NotLoading : LoadingType()
}