package xin.itdev.qa.fragment

import android.app.Application
import xin.itdev.base.ui.BaseVMRepositoryFragment
import xin.itdev.qa.R
import xin.itdev.qa.viewmodel.QaViewModel

class QaFragment : BaseVMRepositoryFragment<QaViewModel>(R.layout.fragment_qa){

    override fun getViewModel(app: Application): QaViewModel = QaViewModel(app)

}