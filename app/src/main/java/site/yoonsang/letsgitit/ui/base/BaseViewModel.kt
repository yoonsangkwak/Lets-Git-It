package site.yoonsang.letsgitit.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import retrofit2.HttpException
import site.yoonsang.letsgitit.model.local.LoadingStatus
import site.yoonsang.letsgitit.model.local.LoadingType
import site.yoonsang.letsgitit.model.local.NetworkErrorType
import site.yoonsang.letsgitit.utils.SingleLiveEvent
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

open class BaseViewModel: ViewModel() {

    val networkErrorType: LiveData<NetworkErrorType>
        get() = _networkErrorType
    private val _networkErrorType = SingleLiveEvent<NetworkErrorType>()

    val loadingStatus: LiveData<LoadingStatus>
        get() = _loadingStatus
    private val _loadingStatus = SingleLiveEvent<LoadingStatus>()

    protected fun CoroutineScope.launchApiCall(
        loadingType: LoadingType = LoadingType.NormalLoading,
        block: suspend CoroutineScope.() -> Unit
    ) {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            when (throwable) {
                is HttpException -> _networkErrorType.value = NetworkErrorType.HttpException
                is SocketTimeoutException -> _networkErrorType.value = NetworkErrorType.SocketTimeoutException
                is UnknownHostException -> _networkErrorType.value = NetworkErrorType.UnknownHostException
                is ConnectException -> _networkErrorType.value = NetworkErrorType.ConnectException
                else -> _networkErrorType.value = NetworkErrorType.OtherException
            }
        }

        this.launch(coroutineExceptionHandler) {
            showLoading(loadingType)
            block.invoke(this)
            hideLoading(loadingType)
        }
    }

    private fun showLoading(loadingType: LoadingType) {
        when (loadingType) {
            LoadingType.NormalLoading -> _loadingStatus.postValue(LoadingStatus.ShowNormalLoading)
            LoadingType.DimLoading -> _loadingStatus.postValue(LoadingStatus.ShowDimLoading)
            LoadingType.NotLoading -> _loadingStatus.postValue(LoadingStatus.NotShowLoading)
        }
    }

    private fun hideLoading(loadingType: LoadingType) {
        when (loadingType) {
            LoadingType.NormalLoading -> _loadingStatus.postValue(LoadingStatus.HideNormalLoading)
            LoadingType.DimLoading -> _loadingStatus.postValue(LoadingStatus.HideDimLoading)
            LoadingType.NotLoading -> _loadingStatus.postValue(LoadingStatus.NotShowLoading)
        }
    }
}