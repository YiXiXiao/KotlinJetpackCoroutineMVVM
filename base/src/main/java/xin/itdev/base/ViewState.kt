package xin.itdev.base

import androidx.lifecycle.Observer
import xin.itdev.base.ui.BaseActivity
import xin.itdev.base.vm.BaseViewModel

/**
 * @author jhb
 * @date 2020/10/22
 */
interface ViewState {

    fun beforeSetView()

    fun onViewInit()

    fun onEvent()

    fun BaseViewModel.dialogState(baseActivity: BaseActivity) {
        isDialogShow.observe(baseActivity, Observer {
            if(it.isShowDialog){
                baseActivity.showLoading(it.msg, it.tag)
            } else {
                baseActivity.hideLoading(it.tag)
            }
        })
    }

    fun BaseViewModel.finish(baseActivity: BaseActivity) {
        isFinish.observe(baseActivity, Observer {
            if (it) {
                baseActivity.finish()
                isFinish.value = false
            }
        })
    }

}