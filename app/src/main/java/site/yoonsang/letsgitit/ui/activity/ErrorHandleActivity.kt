package site.yoonsang.letsgitit.ui.activity

import android.os.Bundle
import site.yoonsang.letsgitit.R
import site.yoonsang.letsgitit.constants.EXTRA_ERROR_MESSAGE
import site.yoonsang.letsgitit.databinding.ActivityErrorHandleBinding
import site.yoonsang.letsgitit.ui.base.BaseActivity

class ErrorHandleActivity: BaseActivity<ActivityErrorHandleBinding>(R.layout.activity_error_handle) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
    }

    private fun initView() {
        val errorMessage = intent.getStringExtra(EXTRA_ERROR_MESSAGE) ?: getString(R.string.error_type_other_exception)
        binding.errorText.text = errorMessage

        binding.refreshButton.setOnClickListener {
            finish()
        }
    }
}