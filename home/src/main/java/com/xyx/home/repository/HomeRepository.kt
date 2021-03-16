package com.xyx.home.repository

import xin.itdev.common.repository.BaseRepository
import com.xyx.home.api.HomeService
import com.xyx.home.common.Contanst
import xin.itdev.network.RetrofitUtil

class HomeRepository : BaseRepository {
    val api by lazy { RetrofitUtil.create<HomeService>(Contanst.MAIN_BASE_URL) }
    
}