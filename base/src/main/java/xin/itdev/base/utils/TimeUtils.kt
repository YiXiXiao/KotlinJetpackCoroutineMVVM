package xin.itdev.base.utils

import java.text.SimpleDateFormat

object TimeUtils{

    const val ONE_DAY_MILLISECONDS = 1000 * 3600 * 24.toLong()

    const val ONE_HOUR_MILLISECONDS = 1000 * 3600.toLong()

    const val ONE_MIN_MILLISECONDS = 1000 * 60.toLong()

    /**
     * 时间日期格式化到年月日时分秒.
     */
    var dateFormatYMDHMS = "yyyy-MM-dd HH:mm:ss"
    var dateFormatYMDHMS_f = "yyyyMMddHHmmss"
    var dateFormatMDHM = "MM-dd HH:mm"
    var dateFormat = "yyyy-MM-dd HH:mm"

    /**
     * 时间日期格式化到年月日.
     */
    var dateFormatYMD = "yyyy-MM-dd"

    /**
     * 时间日期格式化到年月日时分.中文显示
     */
    var dateFormatYMDHMofChinese = "yyyy年MM月dd日 HH:mm"

    /**
     * 时间日期格式化到年月日.中文显示
     */
    var dateFormatYMDofChinese = "yyyy年MM月dd日"

    /**
     * 时间日期格式化到月日.中文显示
     */
    var dateFormatMDofChinese = "MM月dd日"

    /**
     * 时间日期格式化到月.中文显示
     */
    var dateFormatMofChinese = "MM月"

    /**
     * 时间日期格式化到年月.
     */
    var dateFormatYM = "yyyy-MM"

    /**
     * 时间日期格式化到年月日时分.
     */
    var dateFormatYMDHM = "yyyy-MM-dd HH:mm"

    /**
     * 时间日期格式化到月日.
     */
    var dateFormatMD = "MM/dd"
    var dateFormatM_D = "MM-dd"

    var dateFormatM = "MM月"
    var dateFormatD = "dd"
    var dateFormatM2 = "MM"

    var dateFormatMDHMofChinese = "MM月dd日HH时mm分"
    var dateFormatHMofChinese = "HH时mm分"

    /**
     * 时分秒.
     */
    var dateFormatHMS = "HH:mm:ss"

    /**
     * 时分.
     */
    var dateFormatHM = "HH:mm"

    /**
     * 上午/下午时分
     */
    var dateFormatAHM = "aHH:mm"

    var dateFormatYMDE = "yyyy/MM/dd E"
    var dateFormatYMD2 = "yyyy/MM/dd"

    /**
     * 描述：获取milliseconds表示的日期时间的字符串.
     *
     * @param format 格式化字符串，如："yyyy-MM-dd HH:mm:ss"
     * @return String 日期时间字符串
     */
    fun getStringByFormat(milliseconds: Long, format: String?): String? {
        var thisDateTime: String? = null
        try {
            val mSimpleDateFormat = SimpleDateFormat(format)
            thisDateTime = mSimpleDateFormat.format(milliseconds)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return thisDateTime
    }


}