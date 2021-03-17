package xin.itdev.common.bean

import java.io.Serializable

open class BaseBean(
    var errorCode: String? = null,
    var errorMsg: String? = null
) : Serializable