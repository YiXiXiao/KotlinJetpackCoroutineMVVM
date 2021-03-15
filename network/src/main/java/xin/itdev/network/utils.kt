package xin.itdev.network

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import xin.itdev.common.bean.LoadBean
import xin.itdev.common.utils.log
import xin.itdev.common.utils.showFailToast
import xin.itdev.common.vm.BaseViewModel

fun BaseViewModel.launch(showDialog: Boolean = true, finish: (suspend () -> Unit)? = null, error: (suspend () -> Unit)? = null, success: suspend () -> Unit) {
    viewModelScope.launch {
        try {
            dialogState(showDialog, LoadBean(isShowDialog = true))
            success.invoke()
            dialogState(showDialog, LoadBean(isShowDialog = false))
        } catch (e: Throwable) {
            if (error == null) {
                dialogState(showDialog, LoadBean(isShowDialog = false))
                "网络错误 ${e.message}".showFailToast()
            } else {
                error.invoke()
            }
            e.printStackTrace()
            "网络错误: ${e.message}".log()
        } finally {
            finish?.invoke()
        }
    }

}

private fun BaseViewModel.dialogState(showDialog: Boolean, state: LoadBean) {
    if (showDialog) {
        isDialogShow.value = state
    }

}