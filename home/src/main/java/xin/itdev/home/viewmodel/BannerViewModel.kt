package xin.itdev.home.viewmodel

import android.app.Application
import androidx.databinding.ObservableField
import com.alibaba.android.arouter.launcher.ARouter
import com.youth.banner.indicator.CircleIndicator
import com.youth.banner.indicator.Indicator
import com.youth.banner.listener.OnBannerListener
import com.youth.banner.listener.OnPageChangeListener
import xin.itdev.base.utils.showInfoToast
import xin.itdev.base.vm.BaseViewModel
import xin.itdev.base.vm.rv.BaseMultiItemViewModel
import xin.itdev.home.adapter.HomeBannerAdapter
import xin.itdev.home.bean.BannerBean
import xin.itdev.home.common.ItemType

class BannerViewModel(app: Application) : BaseViewModel(app){

    var mAdapterObservable = ObservableField<HomeBannerAdapter>()
    var mIndicatorObservable = ObservableField<Indicator>(CircleIndicator(app))
    var mCurrentPage = 0
    var mPageChangeListener = object : SimpleOnPageChangeListener() {
        override fun onPageSelected(position: Int) {
            mCurrentPage = position
        }
    }

    var mBannerClickListener = OnBannerListener<BannerBean> { data, position ->
        ARouter.getInstance().build("/common/webViewActivity")
            .withString("title", data.content)
            .withString("url", data.link)
            .navigation()

    }

}

abstract class SimpleOnPageChangeListener : OnPageChangeListener {

    override fun onPageScrollStateChanged(state: Int) {}

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

    override fun onPageSelected(position: Int) {}

}