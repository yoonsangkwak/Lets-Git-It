package site.yoonsang.letsgitit.utils

import android.content.Context
import android.content.Intent
import site.yoonsang.letsgitit.ui.activity.MainActivity

object IntentProvider {

    fun getMainIntent(packageContext: Context) =
        Intent(packageContext, MainActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP)
        }
}