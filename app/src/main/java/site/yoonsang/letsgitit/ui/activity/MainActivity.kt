package site.yoonsang.letsgitit.ui.activity

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import site.yoonsang.letsgitit.R
import site.yoonsang.letsgitit.databinding.ActivityMainBinding
import site.yoonsang.letsgitit.ui.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
    }

    private fun initView() {
        val navHost = supportFragmentManager.findFragmentById(R.id.fragment_container) as? NavHostFragment ?: return
        val navController = navHost.navController

        binding.bottomNav.setupWithNavController(navController)
    }
}