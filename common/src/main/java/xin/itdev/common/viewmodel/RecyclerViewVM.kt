package xin.itdev.common.viewmodel

import android.app.Application
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import xin.itdev.base.adapter.QuickViewHolder

open class RecyclerViewVM(app:Application){
    var mRefreshEnable = false
    var mIsRefreshing = ObservableField(false)

    var mAdapterObservable: ObservableField<RecyclerView.Adapter<QuickViewHolder>> = ObservableField()
    var mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(app)

    var mOnScrollListener = ObservableField(RvScrollListener())

    var mOnRefresh = {}

    var mOnLoadMoreListener = {}
}

open class RvScrollListener : RecyclerView.OnScrollListener()