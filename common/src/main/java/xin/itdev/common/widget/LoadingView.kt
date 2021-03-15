package xin.itdev.common.widget

import android.app.AlertDialog
import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import android.widget.TextView
import com.nineoldandroids.animation.ObjectAnimator
import xin.itdev.common.R

class LoadingView(var context: Context) {
    var dialog: AlertDialog
    var builder: AlertDialog.Builder = AlertDialog.Builder(context, R.style.LoadingProgessStyle)
    private var rotateAnimator: ObjectAnimator? = null
    var imageView: ImageView
    var tvMsg: TextView?

    init {
        val v = LayoutInflater.from(context).inflate(R.layout.loading_progressdialog, null)
        tvMsg = v.findViewById(R.id.id_tv_loadingmsg)
        imageView = v.findViewById(R.id.loadingImageView)
        builder.setView(v)
        dialog = builder.create()
        dialog.setCanceledOnTouchOutside(false)
        dialog.setCancelable(true)
    }

    private fun startAnimator() {
        rotateAnimator = ObjectAnimator.ofFloat(imageView, "rotation", 0f, 360f)
        rotateAnimator!!.duration = 1500
        rotateAnimator!!.interpolator = LinearInterpolator()
        rotateAnimator!!.repeatCount = Int.MAX_VALUE
        rotateAnimator!!.start()
    }


    fun dismiss() {
        if (rotateAnimator != null) {
            rotateAnimator!!.cancel()
        }
        dialog.dismiss()
    }

    fun setMessage(strMessage: String?): LoadingView {
        if (tvMsg != null) {
            tvMsg!!.text = strMessage
        }
        return this
    }

    fun show(): LoadingView {
        val window = dialog.window
        window!!.setDimAmount(0f)
        val params = window.attributes
        params.gravity = Gravity.CENTER
        //params.dimAmount = 0.0f;
        //params.alpha = 1f;
        window.attributes = params
        startAnimator()
        dialog.show()
        return this
    }

}