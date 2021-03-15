package xin.itdev.common.ui

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import xin.itdev.common.ViewState
import xin.itdev.common.vm.BaseRepositoryViewModel
import xin.itdev.common.vm.BaseViewModelFactory

/**
 * Created by jhb on 2020/3/20.
 */
abstract class BaseVMRepositoryFragment<T : BaseRepositoryViewModel<*>>(@LayoutRes private val layoutId: Int) : BaseFragment(), ViewState {

    lateinit var mViewModel: T

    abstract fun getViewModel(app: Application): T


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        beforeSetView()

        val vm = getViewModel(mActivity.application)

        mViewModel = ViewModelProvider(this, BaseViewModelFactory(mActivity.application, vm))[vm::class.java]
        val binding = DataBindingUtil.inflate<ViewDataBinding>(inflater, layoutId, container, false)
        binding.lifecycleOwner = this
        binding.setVariable(mViewModel.layoutId(), mViewModel)
        binding.executePendingBindings()

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewInit()

        mViewModel.onModelBind()

        onEvent()
    }

    override fun beforeSetView() {

    }

    override fun onViewInit() {

    }

    override fun onEvent() {

        mViewModel.dialogState(mActivity)
        mViewModel.finish(mActivity)

    }

}