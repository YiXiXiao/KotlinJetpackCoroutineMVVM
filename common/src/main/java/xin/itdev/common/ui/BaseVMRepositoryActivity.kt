package xin.itdev.common.ui

import android.app.Application
import android.os.Bundle

import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import xin.itdev.common.ViewState
import xin.itdev.common.vm.BaseRepositoryViewModel
import xin.itdev.common.vm.BaseViewModelFactory

/**
 * @author xyx
 * @date 2021/03/11
 */
abstract class BaseVMRepositoryActivity<T : BaseRepositoryViewModel<*>>(@LayoutRes private val layoutId: Int) : BaseActivity(), ViewState {

    lateinit var mViewModel: T

    abstract fun getViewModel(app: Application): T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        beforeSetView()

        val vm = getViewModel(application)

        mViewModel = ViewModelProvider(this, BaseViewModelFactory(application, vm))[vm::class.java]
        val binding = DataBindingUtil.setContentView<ViewDataBinding>(this, layoutId)
        binding.lifecycleOwner = this
        binding.setVariable(mViewModel.layoutId(), mViewModel)
        binding.executePendingBindings()

        onViewInit()

        mViewModel.setBound(intent.extras ?: Bundle())

        mViewModel.onModelBind()

        onEvent()
    }

    override fun beforeSetView() {

    }

    override fun onViewInit() {

    }

    override fun onEvent() {

        mViewModel.dialogState(this)
        mViewModel.finish(this)


    }

}