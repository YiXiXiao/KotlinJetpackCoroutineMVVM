package com.xyx.home.viewmodel

import android.app.Application
import com.xyx.home.repository.HomeRepository
import xin.itdev.common.vm.BaseRepositoryViewModel

class HomeViewModel(app:Application) : BaseRepositoryViewModel<HomeRepository>(app, HomeRepository()) {

}