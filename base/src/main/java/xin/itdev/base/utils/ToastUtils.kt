package xin.itdev.base.utils

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.DrawableRes
import xin.itdev.base.R


object ToastUtils {
    fun showSuccessToast(context: Context, content: String) {
        val toast = createToast(context, content, R.mipmap.tip_succeed)
        toast.show()
    }

    fun showFailToast(context: Context, content: String) {
        val toast = createToast(context, content, R.mipmap.tip_fail)
        toast.show()
    }

    fun showInfoToast(context: Context, content: String) {
        val toast = createToast(context, content, R.mipmap.tip_info)
        toast.show()
    }

    fun showCustomToast(context: Context, content: String, @DrawableRes iconRes: Int) {
        val toast = createToast(context, content, iconRes)
        toast.show()
    }


    private fun createToast(context: Context, content: String, @DrawableRes iconRes: Int): Toast {
        val toast = Toast(context)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.duration = Toast.LENGTH_SHORT
        val v = LayoutInflater.from(context).inflate(R.layout.toast, null)
        val icon = v.findViewById<ImageView>(R.id.img_toast_icon)
        icon.setImageResource(iconRes)
        val tvContent = v.findViewById<TextView>(R.id.tv_toast_content)
        tvContent.text = content
        toast.view = v
        return toast
    }

}
