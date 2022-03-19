package site.yoonsang.presentation.ui

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsControllerCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import site.yoonsang.presentation.R

abstract class BaseActivity<T : ViewDataBinding>(@LayoutRes private val layoutResId: Int) :
    AppCompatActivity() {

    protected lateinit var binding: T

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
}