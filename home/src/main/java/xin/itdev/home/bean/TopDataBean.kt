package xin.itdev.home.bean

import xin.itdev.common.bean.BaseBean

data class TopDataBean(
    var index: Int,
    var data: List<ItemDatasBean>?,
    var mLastTime: Long = System.currentTimeMillis()
) : BaseBean()