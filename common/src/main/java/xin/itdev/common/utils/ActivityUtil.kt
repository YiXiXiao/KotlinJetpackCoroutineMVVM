package xin.itdev.common.utils

import android.app.Activity
import java.lang.IllegalArgumentException
import java.util.HashMap

/**
 * @author xyx
 * @date 2021/03/11
 */
object ActivityUtil {

    var mActivities = arrayListOf<Activity>()   //用于记录栈中含有哪些Activity，一次性关闭所有Activity

    val tagActivity = HashMap<String,List<Activity>>()      //用于清除部分Activity

    fun addActivity(activity: Activity) {
        if (!mActivities.contains(activity)) {
            mActivities.add(activity)
        }
    }

    fun removeActivity(activity: Activity) {
        if (mActivities.contains(activity)) {
            mActivities.remove(activity)
        }
    }

    fun getStackTopAct(): Activity {
        if (mActivities.isEmpty()) {
            throw  IllegalArgumentException("can't get Activity ")
        }
        return mActivities[mActivities.size - 1]
    }

    fun finishAllActivity() {
        mActivities.forEach {
            if (!it.isFinishing) {
                it.finish()
            }
        }
    }

    /**
     * 添加Activity
     * @param tag String
     * @param activity Activity
     */
    fun addActivityWithTag(tag:String, activity: Activity){
        var list = ArrayList<Activity>()
        list.add(activity)
        if(tagActivity[tag].isNullOrEmpty()){
            tagActivity[tag] = list
        } else {
            tagActivity[tag]?.let {
                for(value in it){
                    if(list[0] != value){
                        list.add(value)
                    }
                }
            }
        }
        tagActivity[tag]= list
    }

    /**
     * 根据tag关闭Activity
     * @param tag String
     */
    fun clearActivityWithTag(tag: String){
        var list = tagActivity[tag]
        if(list != null){
            for(value in list){
                value.finish()
            }
            tagActivity.remove(tag)
        }
    }

}