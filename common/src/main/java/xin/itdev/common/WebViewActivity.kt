package xin.itdev.common

import android.app.Application
import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.widget.LinearLayout
import com.alibaba.android.arouter.facade.annotation.Route
import com.just.agentweb.AgentWeb
import com.just.agentweb.DefaultWebClient
import com.just.agentweb.WebChromeClient
import com.just.agentweb.WebViewClient
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_web_view.*
import xin.itdev.base.ui.BaseVMRepositoryActivity
import xin.itdev.common.viewmodel.WebViewVM

/**
 * @author XYX
 * @date 2021-03-19
 * 通用WebView  使用agentWeb x5内核
 */
@Route(path = "/common/webViewActivity")
class WebViewActivity : BaseVMRepositoryActivity<WebViewVM>(R.layout.activity_web_view) {

    override fun getViewModel(app: Application): WebViewVM = WebViewVM(app)

    companion object {
        private const val FILTER_URL_JIAN_SHU = "jianshu://notes/"
    }

    private val mUrl by lazy { intent.getStringExtra("url") }

    private lateinit var mAgentWeb: AgentWeb


    override fun onViewInit() {
        super.onViewInit()

        initWeb()

    }

    override fun onEvent() {
        super.onEvent()

    }

    private fun initWeb() {
        mAgentWeb = AgentWeb.with(this)
            .setAgentWebParent(ll_webview, LinearLayout.LayoutParams(-1, -1))
            .useDefaultIndicator(Color.parseColor("#00aefc"))
            .setWebViewClient(mWebViewClient)//WebViewClient ， 与 WebView 使用一致 ，但是请勿获取WebView调用setWebViewClient(xx)方法了,会覆盖AgentWebX5 DefaultWebClient,同时相应的中间件也会失效。
            .setWebChromeClient(mWebChromeClient) //WebChromeClient
            .setSecurityType(AgentWeb.SecurityType.DEFAULT_CHECK) //严格模式 Android 4.2.2 以下会放弃注入对象 ，使用AgentWebView没影响。
            .setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.DISALLOW)//打开其他页面时，弹窗质询用户前往其他应用 AgentWebX5 3.0.0 加入。
            .createAgentWeb()
            .ready()//设置 WebSettings。
            .go(mUrl) //WebView载入该url地址的页面并显示。

        mAgentWeb.agentWebSettings.webSettings.setAppCacheEnabled(false)
    }

    private var mWebViewClient: WebViewClient = object : WebViewClient() {
        override fun onPageStarted(view: WebView, url: String, favicon: Bitmap?) {
            Logger.e("AAAAA", url)
        }

        override fun onPageFinished(view: WebView, url: String) {
            super.onPageFinished(view, url)

        }

        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            return request?.url.toString().contains(FILTER_URL_JIAN_SHU)
        }

    }

    private var mWebChromeClient: WebChromeClient = object : WebChromeClient() {
        override fun onProgressChanged(view: WebView?, newProgress: Int) {
            super.onProgressChanged(view, newProgress)
        }

        override fun onReceivedTitle(view: WebView?, title: String?) {
            super.onReceivedTitle(view, title)
        }
    }

    override fun onPause() {
        mAgentWeb.webLifeCycle.onPause()
        super.onPause()
    }

    override fun onResume() {
        mAgentWeb.webLifeCycle.onResume()
        super.onResume()
    }

    override fun onDestroy() {
        mAgentWeb.webLifeCycle.onDestroy()
        super.onDestroy()
    }

}
