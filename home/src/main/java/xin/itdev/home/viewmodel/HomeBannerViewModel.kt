package xin.itdev.home.viewmodel

import android.app.Application
import androidx.databinding.ObservableField
import com.youth.banner.indicator.CircleIndicator
import com.youth.banner.indicator.Indicator
import com.youth.banner.listener.OnBannerListener
import com.youth.banner.listener.OnPageChangeListener
import xin.itdev.base.utils.showInfoToast
import xin.itdev.base.vm.rv.BaseMultiItemViewModel
import xin.itdev.home.adapter.HomeBannerAdapter
import xin.itdev.home.bean.BannerBean
import xin.itdev.home.common.ItemType

class HomeBannerViewModel(app:Application) : BaseMultiItemViewModel(app){

    override val itemType: Int = ItemType.ITEM_HOME_BANNER

    var mAdapterObservable = ObservableField<HomeBannerAdapter>()
    var mIndicatorObservable = ObservableField<Indicator>(CircleIndicator(app))

    var mCurrentPage = 0
    var mPageChangeListener = object : SimpleOnPageChangeListener() {
        override fun onPageSelected(position: Int) {
            mCurrentPage = position
        }
    }

    var mBannerClickListener = OnBannerListener<BannerBean> { data, position ->
        //TODO  banner 点击事件处理
        "banner点击了".showInfoToast()
    }

}

abstract class SimpleOnPageChangeListener : OnPageChangeListener {

    override fun onPageScrollStateChanged(state: Int) {}

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

    override fun onPageSelected(position: Int) {}

}