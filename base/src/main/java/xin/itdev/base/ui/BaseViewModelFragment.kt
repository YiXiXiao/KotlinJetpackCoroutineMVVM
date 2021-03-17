package xin.itdev.base.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import xin.itdev.base.ViewState
import xin.itdev.base.vm.BaseLayoutViewModel

/**
 * @author xyx
 * @date 2021/03/12
 */
open class BaseViewModelFragment<T : BaseLayoutViewModel>(@LayoutRes private val layoutId: Int, private val clazz: Class<T>) : BaseFragment(), ViewState {

    lateinit var mViewModel: T

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        beforeSetView()
        mViewModel = ViewModelProvider(this)[clazz]
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