package xin.itdev.common.ui

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import xin.itdev.common.ViewState
import xin.itdev.common.vm.BaseLayoutViewModel

/**
 * @author xyx
 * @date 2021/03/11
 * 简单的ViewModel，不结合 Repository使用的，无网络请求页面
 */
open class BaseViewModelActivity<T : BaseLayoutViewModel>(@LayoutRes private val layoutId: Int, private val clazz: Class<T>) : BaseActivity(), ViewState {

    lateinit var mViewModel: T
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        beforeSetView()
        val binding = DataBindingUtil.setContentView<ViewDataBinding>(this, layoutId)
        mViewModel = ViewModelProvider(this)[clazz]
        binding.setVariable(mViewModel.layoutId(), mViewModel)
        binding.lifecycleOwner = this
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

        mViewModel.dialogState(this)        //dialog等待提示观察
        mViewModel.finish(this)

    }
}