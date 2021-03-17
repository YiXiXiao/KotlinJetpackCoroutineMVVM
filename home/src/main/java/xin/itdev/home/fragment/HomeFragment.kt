package xin.itdev.home.fragment

import android.app.Application
import xin.itdev.base.ui.BaseVMRepositoryFragment
import xin.itdev.home.R
import xin.itdev.home.viewmodel.HomeViewModel

class HomeFragment : BaseVMRepositoryFragment<HomeViewModel>(R.layout.fragment_home) {
    override fun getViewModel(app: Application): HomeViewModel = HomeViewModel(app)

    override fun onViewInit() {
        super.onViewInit()

    }

    override fun onEvent() {
        super.onEvent()

    }

}