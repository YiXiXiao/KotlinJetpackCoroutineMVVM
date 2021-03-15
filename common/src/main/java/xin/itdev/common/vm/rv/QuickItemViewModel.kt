package xin.itdev.common.vm.rv

import android.app.Application
import androidx.databinding.library.baseAdapters.BR
import xin.itdev.common.ItemClick
import xin.itdev.common.VariableId
import xin.itdev.common.vm.BaseViewModel

/**
 * @author jhb
 * @date 2020/10/28
 */
open class QuickItemViewModel(app: Application) : BaseViewModel(app), ItemClick, VariableId {

    override fun onItemClick() {}

    override fun layoutId():  Int = BR.item
}