package xin.itdev.base.vm

import android.app.Application
import xin.itdev.base.BR
import xin.itdev.base.VariableId

/**
 * @author xyx
 * @date 2021/03/11
 */
open class BaseLayoutViewModel(app: Application) : BaseViewModel(app), VariableId {

    override fun layoutId() = BR.layout
}