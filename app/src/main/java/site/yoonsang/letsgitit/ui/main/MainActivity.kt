package site.yoonsang.letsgitit.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import com.orhanobut.logger.Logger
import dagger.hilt.android.AndroidEntryPoint
import site.yoonsang.letsgitit.R
import site.yoonsang.letsgitit.databinding.ActivityMainBinding
import site.yoonsang.letsgitit.ui.BaseActivity

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
        initObserver()

        viewModel.searchRepos("kotlin", 1)
    }

    private fun initView() {

    }

    private fun initObserver() {
        viewModel.searchedRepos.observe(this) {
            Logger.d("searchRepos totalCount : ${it.totalCount}\n" +
                    "searchRepos list count : ${it.repoInfos.size}")
        }
    }
}