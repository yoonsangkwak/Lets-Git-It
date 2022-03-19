package site.yoonsang.domain.model

sealed class NetworkErrorType {
    object HttpException : NetworkErrorType()
    object SocketTimeoutException : NetworkErrorType()
    object UnknownHostException : NetworkErrorType()
    object ConnectException : NetworkErrorType()
    object OtherException : NetworkErrorType()
}