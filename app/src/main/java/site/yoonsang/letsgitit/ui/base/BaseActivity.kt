package site.yoonsang.letsgitit.ui.base

import android.os.Bundle
import android.view.WindowInsetsController
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsControllerCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import site.yoonsang.letsgitit.R
import site.yoonsang.letsgitit.model.local.LoadingStatus
import site.yoonsang.letsgitit.model.local.NetworkErrorType
import site.yoonsang.letsgitit.utils.IntentProvider

abstract class BaseActivity<T : ViewDataBinding>(@LayoutRes private val layoutResId: Int) :
    AppCompatActivity() {

    protected lateinit var binding: T

    private var refreshDataCallback: (() -> Unit)? = null

    private val errorHandleLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            refreshDataCallback?.invoke()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutResId)
        setStatusBarColor()
    }

    private fun setStatusBarColor() {
        val decorView = window.decorView
        val windowInsetsController = WindowInsetsControllerCompat(window, decorView)
        window.statusBarColor = getColor(R.color.white)
        windowInsetsController.isAppearanceLightStatusBars = true
    }

    protected fun observeLoadingStatus(vm: BaseViewModel) {
        vm.loadingStatus.observe(this) {
            when (it) {
                LoadingStatus.ShowDimLoading -> TODO()
                LoadingStatus.ShowNormalLoading -> TODO()
                LoadingStatus.HideDimLoading -> TODO()
                LoadingStatus.HideNormalLoading -> TODO()
                else -> Unit
            }
        }
    }

    protected fun observeCommonNetworkError(vm: BaseViewModel) {
        vm.networkErrorType.observe(this) {
            val errorMessage: String = when (it) {
                NetworkErrorType.HttpException -> getString(R.string.error_type_http_exception)
                NetworkErrorType.SocketTimeoutException -> getString(R.string.error_type_socket_time_out_exception)
                NetworkErrorType.UnknownHostException -> getString(R.string.error_type_unknown_host_exception)
                NetworkErrorType.ConnectException -> getString(R.string.error_type_connect_exception)
                NetworkErrorType.OtherException -> getString(R.string.error_type_other_exception)
                else -> getString(R.string.error_type_other_exception)
            }

            val intent = IntentProvider.getErrorHandleIntent(this, errorMessage)
            errorHandleLauncher.launch(intent)
        }
    }

    protected fun registerRefreshData(refreshData: (() -> Unit)) {
        refreshDataCallback = refreshData
    }
}