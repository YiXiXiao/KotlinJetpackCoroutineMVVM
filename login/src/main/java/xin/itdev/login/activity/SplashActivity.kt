package xin.itdev.login.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import xin.itdev.base.utils.delay
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
        requestWindowFeature(Window.FEATURE_NO_TITLE)   // 隐藏标题栏
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)    // 隐藏状态栏
        setContentView(R.layout.activity_splash)
        2000.delay {
            ARouter.getInstance().build("/main/mainActivity").navigation()
            finish()
        }

    }
}
