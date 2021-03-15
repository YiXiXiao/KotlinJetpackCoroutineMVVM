package xin.itdev.login.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_splash.*
import xin.itdev.login.R
@Route(path = "/login/splash")
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        tv_start_main.setOnClickListener {
            ARouter.getInstance().build("/main/mainActivity").navigation()
        }
    }
}
