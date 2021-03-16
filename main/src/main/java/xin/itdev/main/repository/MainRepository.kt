package xin.itdev.main.repository

import xin.itdev.common.repository.BaseRepository
import xin.itdev.main.api.MainService
import xin.itdev.main.common.Contanst
import xin.itdev.network.RetrofitUtil

class MainRepository : BaseRepository {
    val api by lazy { RetrofitUtil.create<MainService>(Contanst.MAIN_BASE_URL) }



}