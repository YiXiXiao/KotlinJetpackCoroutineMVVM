package xin.itdev.home.bean

import com.google.gson.annotations.SerializedName
import xin.itdev.common.bean.BaseBean
import java.io.Serializable

data class ObjectDataBean(
    @SerializedName(value = "data", alternate = ["shareArticles"])
    var data: DataBean? = null
) : BaseBean() {

    data class DataBean(
        var curPage: Int?,
        var datas: List<ItemDatasBean>?,
        var offset: Int?,
        var over: Boolean?,
        var pageCount: Int?,
        var size: Int?,
        var total: Int?,

        var mLastTime: Long = System.currentTimeMillis()

    ) : Serializable
}