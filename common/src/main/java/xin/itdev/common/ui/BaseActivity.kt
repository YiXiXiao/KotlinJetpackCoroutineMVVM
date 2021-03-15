package xin.itdev.common.ui

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import xin.itdev.common.utils.ActivityUtil
import xin.itdev.common.widget.LoadingView
import java.io.Serializable

/**
 * @author xyx
 * @date 2021/03/11
 */
open class BaseActivity  : AppCompatActivity() {

    private var loadViewMap = HashMap<String, LoadingView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityUtil.addActivity(this)
    }

    /**
     * 展示等待提示框，并记录
     */
    fun showLoading(msg: String, loadingTag:String) {
        if(loadViewMap[loadingTag] == null){
            val loadView = LoadingView(this).setMessage(msg).show()
            loadViewMap[loadingTag] = loadView
        }
    }

    /**
     * 根据记录的tag 隐藏提示框
     */
    fun hideLoading(loadingTag: String) {
        if(loadViewMap[loadingTag] != null){
            loadViewMap[loadingTag]?.dismiss()
            loadViewMap.remove(loadingTag)
        }
    }

    fun startActivity(clazz: Class<*>, vararg data: Pair<String, Any?>) {
        val intent = Intent(this, clazz)

        data.forEach {
            when (it.second) {
                is Boolean -> {
                    intent.putExtra(it.first, it.second as Boolean)
                }
                is Byte -> {
                    intent.putExtra(it.first, it.second as Byte)
                }
                is Int -> {
                    intent.putExtra(it.first, it.second as Int)
                }
                is Short -> {
                    intent.putExtra(it.first, it.second as Short)
                }
                is Long -> {
                    intent.putExtra(it.first, it.second as Long)
                }
                is Float -> {
                    intent.putExtra(it.first, it.second as Float)
                }
                is Double -> {
                    intent.putExtra(it.first, it.second as Double)
                }
                is Char -> {
                    intent.putExtra(it.first, it.second as Char)
                }
                is String -> {
                    intent.putExtra(it.first, it.second as String)
                }
                is Serializable -> {
                    intent.putExtra(it.first, it.second as Serializable)
                }
                is Parcelable -> {
                    intent.putExtra(it.first, it.second as Parcelable)
                }
            }
        }

        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityUtil.removeActivity(this)
    }
}