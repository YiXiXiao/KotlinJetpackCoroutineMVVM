package xin.itdev.qa.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import xin.itdev.common.bean.ListDataBaseBean
import xin.itdev.qa.bean.ItemQaBean

interface QaService{

    //问答
    @GET("wenda/list/{page}/json ")
    suspend fun getQaList(@Path("page") page: Int): ListDataBaseBean<ItemQaBean>

}