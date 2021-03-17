package xin.itdev.common

import xin.itdev.base.utils.showToast
import xin.itdev.common.bean.BaseBean
import xin.itdev.common.bean.NetConstant

fun <T : BaseBean> loadDataResponse(bean: T, result: T.() -> Unit) {
    when (bean.errorCode) {
        NetConstant.SUCCESS -> result.invoke(bean)
        else -> bean.errorMsg?.showToast()
    }
}