package xin.itdev.main.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import xin.itdev.common.vm.BaseRepositoryViewModel
import xin.itdev.main.repository.MainRepository

class MainViewModel(app:Application) : BaseRepositoryViewModel<MainRepository>(app, MainRepository()) {
    //RadioGroup点击LiveData改变事件通知
    val mHomeNavClick = MutableLiveData<Int>()

    fun onHomeClick(){
        mHomeNavClick.value = 0
    }

    fun onQaClick(){
        mHomeNavClick.value = 1
    }

    fun onFindClick(){
        mHomeNavClick.value = 2
    }

    fun onMeClick(){
        mHomeNavClick.value = 3
    }

}