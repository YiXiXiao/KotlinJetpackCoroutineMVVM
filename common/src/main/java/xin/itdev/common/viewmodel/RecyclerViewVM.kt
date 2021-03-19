package xin.itdev.common.viewmodel

import android.app.Application
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import xin.itdev.base.adapter.QuickViewHolder

open class RecyclerViewVM(app:Application){
    var mRefreshEnable = false      //是否支持刷新
    var mIsRefreshing = ObservableField(false)  //是否刷新状态，下拉刷新按钮

    var mAdapterObservable: ObservableField<RecyclerView.Adapter<QuickViewHolder>> = ObservableField()  //设置Adapter
    var mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(app)   //recyclerView，纵向

    var mOnScrollListener = ObservableField(RvScrollListener())     //滚动监听

    var mOnRefresh = {}     //刷新执行逻辑

    var mOnLoadMoreListener = {}    //加载更多执行逻辑
}

open class RvScrollListener : RecyclerView.OnScrollListener()