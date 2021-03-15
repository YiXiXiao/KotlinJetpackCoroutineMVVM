package xin.itdev.common.vm

import android.app.Application
import xin.itdev.common.BR
import xin.itdev.common.VariableId

/**
 * @author xyx
 * @date 2021/03/11
 */
open class BaseLayoutViewModel(app: Application) : BaseViewModel(app), VariableId {

    override fun layoutId() = BR.layout
}