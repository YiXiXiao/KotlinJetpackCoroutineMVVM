package xin.itdev.common.viewmodel

import android.graphics.drawable.Drawable
import androidx.databinding.ObservableField
import xin.itdev.base.utils.getDrawable
import xin.itdev.base.utils.getResColor
import xin.itdev.common.R

class TitleViewModel(var leftText: String? = "",
                     var leftDrawable: Drawable? = R.drawable.back_icon.getDrawable(),
                     var leftAction: (() -> Unit)? = null,
                     var title: String = "",
                     var rightText: String = "",
                     var rightDrawable: Drawable? = null,
                     var rightAction: (() -> Unit)? = null,
                     var background: Int = R.color.color_white.getResColor()

) {
    val mTitle = ObservableField(title)
    val mRightDrawable = ObservableField(rightDrawable)
}