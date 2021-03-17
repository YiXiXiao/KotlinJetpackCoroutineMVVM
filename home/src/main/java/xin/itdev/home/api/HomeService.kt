package xin.itdev.home.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import xin.itdev.home.bean.BannerDataBean
import xin.itdev.home.bean.ObjectDataBean
import xin.itdev.home.bean.TopDataBean

interface HomeService{
    //首页banner
    @GET("/banner/json")
    suspend fun getBannerList(): BannerDataBean

    //置顶文章
    @GET("/article/top/json")
    suspend fun getArticleTop(): TopDataBean

    /**
     *  1.首页文章列表
     *  2.知识体系下的文章  cid 分类的id，上述二级目录的id
     */
    @GET("/article/list/{page}/json")
    suspend fun getArticleList(@Path("page") page: Int, @Query("cid") cid: Int? = null) : ObjectDataBean  //73为面试的cid)
}