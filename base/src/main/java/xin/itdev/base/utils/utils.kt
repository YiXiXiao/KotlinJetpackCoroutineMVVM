package xin.itdev.base.utils

import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.orhanobut.logger.Logger
import xin.itdev.base.BaseApp
import xin.itdev.base.BuildConfig

/**
 * 扩展函数
 */

enum class LogEnum {
    VERBOSE, DEBUG, INFO, WARN, ERROR
}

fun String.log(logEnum: LogEnum = LogEnum.ERROR) {
    if (BuildConfig.DEBUG) {
        when (logEnum) {
            LogEnum.VERBOSE -> Logger.v(this)
            LogEnum.DEBUG -> Logger.d(this)
            LogEnum.INFO -> Logger.i(this)
            LogEnum.WARN -> Logger.w(this)
            LogEnum.ERROR -> Logger.e(this)
        }
    }
}

fun String.showToast(length:Int = Toast.LENGTH_SHORT){
    Toast.makeText(BaseApp.instance.applicationContext, this, length).show()
}

fun String.showSuccessToast(){
    ToastUtils.showSuccessToast(BaseApp.instance, this)
}

fun String.showInfoToast(){
    ToastUtils.showInfoToast(BaseApp.instance, this)
}

fun String.showFailToast(){
    ToastUtils.showFailToast(BaseApp.instance, this)
}

fun Int.delay(action: () -> Unit) {
    Handler(Looper.getMainLooper()).postDelayed({ action.invoke() }, this.toLong())
}

fun Int.getDrawable() = ActivityCompat.getDrawable(BaseApp.instance, this)

fun Int.getResString() = BaseApp.instance.getString(this)

fun Int.getResColor() = ContextCompat.getColor(BaseApp.instance, this)


