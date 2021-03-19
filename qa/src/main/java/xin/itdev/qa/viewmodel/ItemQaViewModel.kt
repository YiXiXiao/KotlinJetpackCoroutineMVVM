package xin.itdev.qa.viewmodel

import android.app.Application
import androidx.databinding.ObservableField
import com.alibaba.android.arouter.launcher.ARouter
import xin.itdev.base.utils.TimeUtils
import xin.itdev.base.utils.showInfoToast
import xin.itdev.base.vm.rv.BaseItemViewModel
import xin.itdev.qa.bean.ItemQaBean

class ItemQaViewModel(app:Application, private val bean : ItemQaBean?):BaseItemViewModel(app) {
    var mTitle = ObservableField("")
    var mAuthor = ObservableField("")
    var mCategory = ObservableField("")
    var mTime = ObservableField("")
    var mLink: String? = ""
    var mId: Int? = null
    var mOriginId: Int = -1

    override fun onItemClick() {

        ARouter.getInstance().build("/common/webViewActivity")
            .withString("title", mTitle.get())
            .withString("url", mLink)
            .navigation()

    }

    /**
     * 数据赋值
     */
    fun bindData(){

        mTitle.set(bean?.title)

        if (!bean?.author.isNullOrEmpty()) {
            mAuthor.set("作者: ${bean?.author}")
        } else if (!bean?.shareUser.isNullOrEmpty()) {
            mAuthor.set("分享人: ${bean?.shareUser}")
        }

        bean?.superChapterName?.let {
            mCategory.set("分类: $it")
        }

        mTime.set(TimeUtils.getStringByFormat(bean?.publishTime!!, TimeUtils.dateFormatYMDHMS))

        mId = bean?.id
        mLink = bean?.link
        mOriginId = bean?.originId ?: -1

    }

}