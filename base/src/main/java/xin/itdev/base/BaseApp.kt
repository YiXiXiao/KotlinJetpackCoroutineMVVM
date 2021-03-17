package xin.itdev.base

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.alibaba.android.arouter.launcher.ARouter
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import com.tencent.mmkv.MMKV

/**
 * @author xyx
 * @date 2021/03/11
 */
open class BaseApp : Application() {

    companion object{
        lateinit var instance:BaseApp
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        initSDK()
    }

    /**
     * 初始部分SDK
     */
    private fun initSDK() {
        /**
         * 配置Log
         */
        val formatStrategy = PrettyFormatStrategy.newBuilder()
            .showThreadInfo(false)
            .methodCount(1)
            .tag("BANJOY_LIVE_TAG")
            .build()
        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))

        //配置MMKV
        MMKV.initialize(this)

        //初始化路由
        if (BuildConfig.DEBUG) {
            //一定要在ARouter.init之前调用openDebug
            ARouter.openDebug()
            ARouter.openLog()
        }
        ARouter.init(this)

    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        //针对5.0以下系统 65535的问题
        MultiDex.install(this)
    }


}