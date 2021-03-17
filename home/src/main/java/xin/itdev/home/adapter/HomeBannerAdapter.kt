package xin.itdev.home.adapter

import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import xin.itdev.home.bean.BannerBean

class HomeBannerAdapter(mData: MutableList<BannerBean>?) : BannerImageAdapter<BannerBean>(mData) {
    override fun onBindView(holder: BannerImageHolder, data: BannerBean?, position: Int, size: Int) {
        //图片加载自己实现
        Glide.with(holder.itemView)
            .load(data?.imagePath)
            .apply(RequestOptions.bitmapTransform(RoundedCorners(30)))
            .into(holder.imageView)

    }
}