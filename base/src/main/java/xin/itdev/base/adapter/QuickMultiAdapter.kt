package xin.itdev.base.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import xin.itdev.base.VariableId
import xin.itdev.base.vm.rv.BaseMultiItemViewModel

/**
 * @author xyx
 * @date 2021/03/12
 * 多样式布局adapter
 */
class QuickMultiAdapter<T : BaseMultiItemViewModel>(mData: MutableList<T>) : BaseMultiItemQuickAdapter<T, QuickViewHolder>(mData) {

    override fun createBaseViewHolder(parent: ViewGroup, layoutResId: Int): QuickViewHolder = QuickViewHolder.create(layoutResId, parent)

    override fun convert(holder: QuickViewHolder, item: T) {
        holder.bind(item)
    }

    fun addHeader(context: Context, @LayoutRes layoutId: Int, header: VariableId) {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(context), layoutId, null, false)
        binding.setVariable(header.layoutId(), header)
        binding.executePendingBindings()
        addHeaderView(binding.root)
    }

    fun addType(@LayoutRes layoutId: Int, type: Int) {
        addItemType(type, layoutId)
    }


}