package xin.itdev.common.utils

import android.widget.Toast
import com.orhanobut.logger.Logger
import xin.itdev.common.BaseApp
import xin.itdev.common.BuildConfig

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


