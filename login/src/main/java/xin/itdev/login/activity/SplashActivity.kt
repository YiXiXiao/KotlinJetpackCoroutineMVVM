package xin.itdev.login.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.coroutines.delay
import xin.itdev.common.utils.delay
import xin.itdev.login.R

/**
 * @author XYX
 * @date  2021-03-16
 * 启动页面
 */
@Route(path = "/login/splash")
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        2000.delay {
            ARouter.getInstance().build("/main/mainActivity").navigation()
            finish()
        }

    }
}
