package xin.itdev.common.viewmodel

import android.app.Application
import xin.itdev.base.vm.BaseRepositoryViewModel
import xin.itdev.common.repository.WebViewRepository

class WebViewVM(app:Application) : BaseRepositoryViewModel<WebViewRepository>(app, WebViewRepository()) {

    var mTitleVM = TitleViewModel(
        leftAction = {
            finish()
        },
        title = ""
    )

    override fun onModelBind() {
        super.onModelBind()
        mTitleVM.mTitle.set(mBundle.getString("title",""))
    }
}