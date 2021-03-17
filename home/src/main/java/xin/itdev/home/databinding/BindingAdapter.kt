package xin.itdev.home.databinding

import androidx.databinding.BindingAdapter
import com.youth.banner.Banner
import com.youth.banner.indicator.Indicator
import com.youth.banner.listener.OnBannerListener
import com.youth.banner.listener.OnPageChangeListener
import xin.itdev.home.adapter.HomeBannerAdapter


@BindingAdapter("setBannerAdapter")
fun setBannerAdapter(banner: Banner<*, HomeBannerAdapter>, adapter: HomeBannerAdapter) {
    if (banner.adapter != adapter) {
        banner.adapter = adapter
    }
}

@BindingAdapter("setBannerIndicator")
fun setBannerIndicator(banner: Banner<*, HomeBannerAdapter>, indicator: Indicator) {
    banner.indicator = indicator
}

@BindingAdapter("setBannerPageChangeListener")
fun setBannerPageChangeListener(banner: Banner<*, HomeBannerAdapter>, listener: OnPageChangeListener?) {
    if (listener == null) return
    banner.addOnPageChangeListener(listener)
}

@BindingAdapter("setBannerClickListener")
fun setBannerClickListener(banner: Banner<*, HomeBannerAdapter>, listener: OnBannerListener<*>?) {
    if (listener == null) return
    banner.setOnBannerListener(listener)
}