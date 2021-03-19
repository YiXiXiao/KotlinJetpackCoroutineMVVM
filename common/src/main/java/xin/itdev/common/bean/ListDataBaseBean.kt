package xin.itdev.common.bean

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ListDataBaseBean<T>(
    @SerializedName(value = "data", alternate = ["shareArticles"])
    var data: DataBean<T>? = null
) : BaseBean() {

    data class DataBean<T>(
        var curPage: Int?,
        var datas: List<T>?,
        var offset: Int?,
        var over: Boolean?,
        var pageCount: Int?,
        var size: Int?,
        var total: Int?,

        var mLastTime: Long = System.currentTimeMillis()

    ) : Serializable
}