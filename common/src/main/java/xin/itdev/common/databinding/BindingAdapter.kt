package xin.itdev.common.databinding

import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.annotation.RawRes
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton

import xin.itdev.common.R

/**
 * Created by jhb on 2020/3/26.
 */
@BindingAdapter("android:src", requireAll = false)
fun setUri(imageView: ImageView, @RawRes resId: Int) {
    Glide.with(imageView).load(resId).into(imageView)
}

@BindingAdapter("loadUrl", requireAll = false)
fun loadUrl(imageView: ImageView, path: String?) {
    Glide.with(imageView)
        .applyDefaultRequestOptions(RequestOptions()
            .placeholder(R.mipmap.ic_launcher)
            .centerCrop())
        .load(path).into(imageView)
}

@BindingAdapter("setAvatar", requireAll = false)
fun setAvatar(imageView: ImageView, path: String) {
    Glide.with(imageView)
        .applyDefaultRequestOptions(RequestOptions()
//            .transform(RoundedCorners(6))//圆角图片
            .circleCrop())//圆形图片
        .load(path)
        .into(imageView)
}

@BindingAdapter(value = ["onRefreshListener"], requireAll = false)
fun onRefreshListener(swipeRefreshLayout: SwipeRefreshLayout, listener: (() -> Unit)?) {
    swipeRefreshLayout.setOnRefreshListener {
        listener?.invoke()
    }
}

@BindingAdapter("rvScrollToTop")
fun rvScrollToTop(recyclerView: RecyclerView, isToTop: Boolean) {
    if (isToTop) {
        recyclerView.smoothScrollToPosition(0)
    }
}

@BindingAdapter(value = ["setLoadMoreListener"], requireAll = false)
fun setLoadMoreListener(recyclerView: RecyclerView, listener: (() -> Unit)?) {

    var isToTop = false

    recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)

            val lm = recyclerView.layoutManager
            if (lm is LinearLayoutManager) {
                val lastVisibleItemPosition = lm.findLastVisibleItemPosition()
                val totalItemCount = recyclerView.adapter?.itemCount ?: 0
                val visibleChildCount = recyclerView.childCount

                if (
                    isToTop &&
                    newState == RecyclerView.SCROLL_STATE_IDLE &&
                    totalItemCount != 0 &&
                    lastVisibleItemPosition == totalItemCount - 1 &&
                    visibleChildCount != 0
                ) {
                    listener?.invoke()
                }
            }
        }

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            isToTop = dy > 0
        }
    })
}


@BindingAdapter("layoutHeight")
fun layoutHeight(view: View, dp: Int) {
    val layoutParams = view.layoutParams
    layoutParams.height = dp
    view.layoutParams = layoutParams
}


@BindingAdapter("layoutWidth")
fun layoutWidth(view: View, dp: Int) {
    val layoutParams = view.layoutParams
    layoutParams.width = dp
    view.layoutParams = layoutParams
}

@BindingAdapter("fabCustomSize")
fun fabCustomSize(fab: FloatingActionButton, dp: Int) {
    fab.customSize = dp
}



@BindingAdapter("etSetSelect")
fun etSetSelect(editText: EditText, position: Int) {
    editText.setSelection(position)
}




