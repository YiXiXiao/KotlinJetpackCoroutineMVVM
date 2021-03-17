package xin.itdev.base.vm.rv

import android.app.Application
import androidx.databinding.library.baseAdapters.BR
import xin.itdev.base.ItemClick
import xin.itdev.base.VariableId
import xin.itdev.base.vm.BaseViewModel

/**
 * @author jhb
 * @date 2020/10/28
 */
open class QuickItemViewModel(app: Application) : BaseViewModel(app), ItemClick, VariableId {

    override fun onItemClick() {}

    override fun layoutId():  Int = BR.item
}