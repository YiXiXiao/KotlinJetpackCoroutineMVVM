package xin.itdev.home.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import retrofit2.adapter.rxjava2.Result.response
import xin.itdev.base.repository.BaseRepository
import xin.itdev.home.api.HomeService
import xin.itdev.home.common.Contanst
import xin.itdev.network.RetrofitUtil

class HomeRepository : BaseRepository {

    val api by lazy { RetrofitUtil.create<HomeService>(Contanst.MAIN_BASE_URL) }

    suspend fun getBannerList() = withContext(Dispatchers.IO) {
        async {
            //TODO 后续添加数据库
            api.getBannerList()
        }
    }.await()

    suspend fun getArticleTop() = withContext(Dispatchers.IO){
        async {
            api.getArticleTop()
        }
    }.await()

    suspend fun getArticleList(page:Int) = withContext(Dispatchers.IO){
        async {
            api.getArticleList(page)
        }
    }.await()
    
}