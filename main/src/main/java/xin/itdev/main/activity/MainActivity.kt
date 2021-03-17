package xin.itdev.main.activity

import android.app.Application
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.alibaba.android.arouter.facade.annotation.Route
import kotlinx.android.synthetic.main.activity_main.*
import xin.itdev.base.ui.BaseVMRepositoryActivity
import xin.itdev.main.R
import xin.itdev.main.adapter.MainVPAdapter
import xin.itdev.home.fragment.HomeFragment
import xin.itdev.main.viewmodel.MainViewModel

/**
 * @author XYX
 * @date 2021-03-16
 * 使用ViewPager2 RadioGroup 构建主页
 */
@Route(path = "/main/mainActivity")
class MainActivity : BaseVMRepositoryActivity<MainViewModel>(R.layout.activity_main) {

    private val mFragments = arrayListOf<Fragment>()
    //默认选择第一个  首页
    private var mPagePosition = 0

    override fun getViewModel(app: Application) = MainViewModel(app)

    override fun onViewInit() {
        super.onViewInit()

        initFragment()

    }

    override fun onEvent() {
        super.onEvent()

        mViewModel.mHomeNavClick.observe(this, Observer {
            setPagePosition(it)
        })

    }

    /**
     * 切换选择的模块
     */
    private fun setPagePosition(position: Int) {
        viewPage.setCurrentItem(position, false)
    }

    /**
     * 初始化Fragmen
     */
    private fun initFragment() {
        if (mFragments.isNotEmpty()) {
            mFragments.clear()
        }
        mFragments.add(HomeFragment())
        mFragments.add(HomeFragment())
        mFragments.add(HomeFragment())
        mFragments.add(HomeFragment())

        viewPage.adapter = MainVPAdapter(mFragments, supportFragmentManager, lifecycle)
        //是否开启联动
        viewPage.isUserInputEnabled = true
        viewPage.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setButtonState(position)
            }
        })
    }

    fun setButtonState(position: Int) {
        mPagePosition = position
        when (position) {
            0 -> {
                llNav.check(R.id.rb0)
            }
            1 -> {
                llNav.check(R.id.rb1)

            }
            2 -> {
                llNav.check(R.id.rb2)
            }
            3 -> {
                llNav.check(R.id.rb3)
            }

        }
    }

}
