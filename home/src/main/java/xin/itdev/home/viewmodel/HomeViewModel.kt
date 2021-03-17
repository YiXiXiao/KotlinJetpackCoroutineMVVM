package xin.itdev.home.viewmodel

import android.app.Application
import xin.itdev.base.adapter.QuickMultiAdapter
import xin.itdev.base.utils.showToast
import xin.itdev.home.repository.HomeRepository
import xin.itdev.base.vm.BaseRepositoryViewModel
import xin.itdev.base.vm.rv.BaseMultiItemViewModel
import xin.itdev.common.loadDataResponse
import xin.itdev.common.viewmodel.RecyclerViewVM
import xin.itdev.common.viewmodel.TitleViewModel
import xin.itdev.home.R
import xin.itdev.home.adapter.HomeBannerAdapter
import xin.itdev.home.bean.BannerBean
import xin.itdev.home.bean.ItemDatasBean
import xin.itdev.home.common.ItemType
import xin.itdev.network.launch

enum class HomePageState {
    INIT, REFRESH, LOAD_MORE
}

class HomeViewModel(app:Application) : BaseRepositoryViewModel<HomeRepository>(app, HomeRepository()) {

    var mTitleVM = TitleViewModel(
        leftDrawable = null,
        title = "首页"
    )

    private val mBannerBeanList = arrayListOf<BannerBean>()

    private val mBannerAdapter = HomeBannerAdapter(mBannerBeanList)
    private var mBannerViewModel = HomeBannerViewModel(getApplication()).apply {
        mAdapterObservable.set(mBannerAdapter)
    }

    //多Item数据
    private val mData = arrayListOf<BaseMultiItemViewModel>()
    //多ItemAdapter
    private val mAdapter = QuickMultiAdapter(mData).apply {
//        addHeader()   //添加header头
        addType(R.layout.item_home_banner, ItemType.ITEM_HOME_BANNER)
        addType(R.layout.item_home_rv, ItemType.ITEM_HOME_RV)
    }

    private var mCurrPage = 0
    private var mTotalPage = 1

    var rvVM = RecyclerViewVM(app).apply {
        mRefreshEnable = true
        mAdapterObservable.set(mAdapter)

        mOnRefresh = {
            mIsRefreshing.set(true)

            mData.clear()
            mCurrPage = 0
            requestServer(HomePageState.REFRESH)

        }

        mOnLoadMoreListener = {
            mCurrPage++
            if (mCurrPage < mTotalPage) {
                requestServer(HomePageState.LOAD_MORE)
            } else {
                "没有更多了".showToast()
            }
        }
    }


    override fun onModelBind() {
        super.onModelBind()

        requestServer(HomePageState.INIT)

    }

    private fun hideRefreshLoading(state: HomePageState) {
        if (state == HomePageState.REFRESH) {
            rvVM.mIsRefreshing.set(false)
        }
    }

    private fun requestServer(state: HomePageState) {
        launch{
            if (state == HomePageState.INIT || state == HomePageState.REFRESH) {
                //获取banner数据
                mBannerBeanList.clear()
                loadDataResponse(mRepo.getBannerList()){
                    this.data?.forEach {
                        mBannerBeanList.add(BannerBean(it.imagePath, it.title, it.url))
                    }
                }
                mData.add(mBannerViewModel)

                //获取置顶数据
                loadDataResponse(mRepo.getArticleTop()){
                    this.data?.forEach {
                        bindData(it)
                    }
                }
            }

            //获取文章数据
            loadDataResponse(mRepo.getArticleList(mCurrPage)){
                this.data.apply {
                    mTotalPage =  this?.pageCount ?: 1
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

    private fun bindData(bean: ItemDatasBean) {
        mData.add(ItemHomeViewModel(getApplication(), bean).apply {
            bindData()
        })
    }

}