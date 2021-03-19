package xin.itdev.qa.viewmodel

import android.app.Application
import xin.itdev.base.adapter.QuickAdapter
import xin.itdev.base.utils.showToast
import xin.itdev.base.vm.BaseRepositoryViewModel
import xin.itdev.common.bean.PageState
import xin.itdev.common.loadDataResponse
import xin.itdev.common.viewmodel.RecyclerViewVM
import xin.itdev.common.viewmodel.TitleViewModel
import xin.itdev.network.launch
import xin.itdev.qa.R
import xin.itdev.qa.bean.ItemQaBean
import xin.itdev.qa.repository.QaRepository


class QaViewModel(app:Application) : BaseRepositoryViewModel<QaRepository>(app, QaRepository()) {

    var mTitleVM = TitleViewModel(
        leftDrawable = null,
        title = "问答"
    )

    private var mCurrPage = 0
    private var mTotalPage = 1

    private val mData = arrayListOf<ItemQaViewModel>()
    private val mAdapter = QuickAdapter(R.layout.item_rv_qa, mData)

    var rvVM = RecyclerViewVM(app).apply {
        mRefreshEnable = true

        mAdapterObservable.set(mAdapter)

        mOnRefresh = {
            mIsRefreshing.set(true)

            mCurrPage = 0
            requestServer(PageState.REFRESH)

        }

        mOnLoadMoreListener = {
            mCurrPage++
            if (mCurrPage < mTotalPage) {
                requestServer(PageState.LOAD_MORE)
            } else {
                "没有更多了".showToast()
            }
        }
    }

    override fun onModelBind() {
        super.onModelBind()
        requestServer(PageState.INIT)
    }

    /**
     * 请求数据
     */
    private fun requestServer(state: PageState) {
        //开启协程作用域
        launch(!(state == PageState.INIT || state == PageState.REFRESH)) {
            loadDataResponse(mRepo.getQaList(mCurrPage)){
                this.data.apply {
                    mTotalPage = this?.pageCount ?: 1
                    if(state == PageState.INIT || state == PageState.REFRESH){
                        mData.clear()
                    }
                    this?.datas?.forEach {
                        bindData(it)
                    }
                }
            }

            //刷新页面
            mAdapter.notifyDataSetChanged()
            //隐藏刷新状态
            hideRefreshLoading(state)

        }
    }

    private fun bindData(data: ItemQaBean) {
        mData.add(ItemQaViewModel(getApplication(), data).apply {
            bindData()
        })
    }

    private fun hideRefreshLoading(state: PageState) {
        if (state == PageState.REFRESH) {
            rvVM.mIsRefreshing.set(false)
        }
    }

}