package xin.itdev.home.viewmodel

import android.app.Application
import androidx.databinding.ObservableField
import xin.itdev.base.vm.rv.BaseMultiItemViewModel
import xin.itdev.home.common.ItemType

/**
 * @author jhb
 * @date 2020/10/27
 */
class HomeBannerVM(app: Application) : BaseMultiItemViewModel(app) {


    var mBannerVM = ObservableField<BannerViewModel>()


    override val itemType: Int = ItemType.ITEM_HOME_BANNER
}