package xin.itdev.base.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment

/**
 * @author xyx
 * @date 2021/03/12
 */
open class BaseFragment : Fragment() {

    lateinit var mActivity: BaseActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = context as BaseActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}