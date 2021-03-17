package xin.itdev.home.bean

import xin.itdev.common.bean.BaseBean

data class BannerDataBean(
    var index: Int,
    var data: List<Data>?,
    var mLastTime: Long = System.currentTimeMillis()
) : BaseBean() {
    data class Data(
        var desc: String?,
        var id: Int?,
        var isVisible: Int?,
        var order: Int?,
        var type: Int?,
        var imagePath: String?,
        var title: String?,
        var url: String?
    )
}