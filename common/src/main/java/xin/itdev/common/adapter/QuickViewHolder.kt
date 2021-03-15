package xin.itdev.common.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import xin.itdev.common.VariableId

/**
 * @author xyx
 * @date 2021/03/12
 */
class QuickViewHolder(private val mBinding: ViewDataBinding) : BaseViewHolder(mBinding.root) {

    companion object {

        fun create(@LayoutRes layoutId: Int, parent: ViewGroup): QuickViewHolder =
                QuickViewHolder(DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(parent.context), layoutId, parent, false))


    }


    fun <T : VariableId> bind(item: T) {
        mBinding.setVariable(item.layoutId(), item)
        mBinding.executePendingBindings()
    }


}