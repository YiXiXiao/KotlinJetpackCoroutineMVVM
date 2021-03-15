package xin.itdev.common.vm

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * @author jhb
 * @date 2020/10/23
 */
@Suppress("UNCHECKED_CAST")
open class BaseViewModelFactory(app: Application, private val viewModel: BaseRepositoryViewModel<*>) : ViewModelProvider.AndroidViewModelFactory(app) {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return viewModel as T
    }

}