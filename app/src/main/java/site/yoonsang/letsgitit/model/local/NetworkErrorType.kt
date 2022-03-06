package site.yoonsang.letsgitit.model.local

sealed class NetworkErrorType {
    object HttpException : NetworkErrorType()
    object SocketTimeoutException : NetworkErrorType()
    object UnknownHostException : NetworkErrorType()
    object ConnectException : NetworkErrorType()
    object OtherException : NetworkErrorType()
}