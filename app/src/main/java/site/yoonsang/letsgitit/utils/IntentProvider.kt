package site.yoonsang.letsgitit.utils

import android.content.Context
import android.content.Intent
import site.yoonsang.letsgitit.constants.EXTRA_ERROR_MESSAGE
import site.yoonsang.letsgitit.ui.activity.ErrorHandleActivity
import site.yoonsang.letsgitit.ui.activity.MainActivity

object IntentProvider {

    fun getMainIntent(packageContext: Context) =
        Intent(packageContext, MainActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP)
        }

    fun getErrorHandleIntent(packageContext: Context, errorMessage: String) =
        Intent(packageContext, ErrorHandleActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NO_HISTORY)
            putExtra(EXTRA_ERROR_MESSAGE, errorMessage)
        }
}