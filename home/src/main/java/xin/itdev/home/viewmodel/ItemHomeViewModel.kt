package xin.itdev.home.viewmodel

import android.app.Application
import androidx.databinding.ObservableField
import xin.itdev.base.utils.showInfoToast
import xin.itdev.base.vm.rv.BaseMultiItemViewModel
import xin.itdev.home.bean.ItemDatasBean
import xin.itdev.home.common.ItemType

class ItemHomeViewModel(app: Application, private val bean: ItemDatasBean? = null) : BaseMultiItemViewModel(app) {
    var mTitle = ObservableField("")
    var mAuthor = ObservableField("")
    var mCategory = ObservableField("")
    var mLink: String? = ""
    var mId: Int? = null
    var mOriginId: Int = -1

    override fun onItemClick() {

        "item点击了".showInfoToast()

    }

    fun bindData() {
        setTitle()
        setAuthor()
        setCategory()
        mId = bean?.id
        mLink = bean?.link
        mOriginId = bean?.originId ?: -1
    }

    fun setTitle() {
        mTitle.set(bean?.title)
    }

    fun setAuthor() {
        if (!bean?.author.isNullOrEmpty()) {
            mAuthor.set("作者: ${bean?.author}")
        } else if (!bean?.shareUser.isNullOrEmpty()) {
            mAuthor.set("分享人: ${bean?.shareUser}")
        }
    }

    fun setCategory() {
        bean?.superChapterName?.let {
            mCategory.set("分类: $it")
        }
    }

    override val itemType = ItemType.ITEM_HOME_RV
}