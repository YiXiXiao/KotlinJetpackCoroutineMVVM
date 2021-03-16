package com.xyx.home.fragment

import android.app.Application
import com.xyx.home.R
import xin.itdev.common.ui.BaseVMRepositoryFragment
import com.xyx.home.viewmodel.HomeViewModel

class HomeFragment : BaseVMRepositoryFragment<HomeViewModel>(R.layout.fragment_home) {
    override fun getViewModel(app: Application): HomeViewModel = HomeViewModel(app)

    override fun onViewInit() {
        super.onViewInit()

    }

    override fun onEvent() {
        super.onEvent()

    }

}