package xin.itdev.common.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import xin.itdev.common.VariableId
import xin.itdev.common.vm.rv.QuickItemViewModel

/**
 * @author xyx
 * @date 2021/03/12
 */
class QuickAdapter<T : QuickItemViewModel>(@LayoutRes var layoutId: Int, mData: MutableList<T>) : BaseQuickAdapter<T, QuickViewHolder>(layoutId, mData) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuickViewHolder = QuickViewHolder.create(layoutId, parent)

    override fun convert(holder: QuickViewHolder, item: T) {
        holder.bind(item)
    }

    override fun getItemViewType(position: Int) = position

    fun addHeader(context: Context, @LayoutRes layoutId: Int, header: VariableId) {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(context), layoutId, null, false)
        binding.setVariable(header.layoutId(), header)
        binding.executePendingBindings()
        addHeaderView(binding.root)
    }


}