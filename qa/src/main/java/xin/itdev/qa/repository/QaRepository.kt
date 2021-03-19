package xin.itdev.qa.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import xin.itdev.base.repository.BaseRepository
import xin.itdev.network.RetrofitUtil
import xin.itdev.qa.api.QaService
import xin.itdev.qa.common.Contanst

class QaRepository : BaseRepository {

    val api by lazy { RetrofitUtil.create<QaService>(Contanst.MAIN_BASE_URL) }

    suspend fun getQaList(page:Int) = withContext(Dispatchers.IO){
        async {
            api.getQaList(page)
        }
    }.await()
}