package com.wbacbc.buttontoggle

import android.app.Activity
import android.view.View
import android.widget.Button


/**
 * https://blog.csdn.net/Benlve/article/details/126544488
 * 多选按钮操作工具类 用于定位控件（findView）、设置按钮选中状态、设置监听（setListener）
 */
object SelectButtonUtil {
    /**
     * findView
     *
     * @param activity view对应的Activity对象
     * @param btnArr   多选按钮数组
     * @param idArr    多选按钮数组button对应的id数组
     */
    fun findButton(activity: Activity, btnArr: Array<Button?>, idArr: IntArray) {
        for (i in btnArr.indices) {
            btnArr[i] = activity.findViewById(idArr[i])
        }
    }

    /**
     * 设置按钮状态
     *
     * @param index    选中按钮对应的数组角标
     * @param activity view对应的Activity对象
     * @param btnArr   多选按钮数组
     * @param idArr    多选按钮数组button对应的id数组
     */
    fun setState(index: Int, activity: Activity?, btnArr: Array<Button?>, idArr: IntArray?) {
        for (i in btnArr.indices) {
            if (i == index) {
                btnArr[i]!!.isSelected = true
            } else {
                btnArr[i]!!.isSelected = false
            }
        }
    }

    /**
     * 设置按钮监听
     *
     * @param activity view对应的Activity对象
     * @param btnArr   多选按钮数组
     * @param idArr    多选按钮数组button对应的id数组
     * @param listener 监听实现类，一般放到Activity里实现，传入Activity对象
     */
    fun setListener(
        activity: Activity?,
        btnArr: Array<Button?>,
        idArr: IntArray?,
        listener: View.OnClickListener?
    ) {
        for (i in btnArr.indices) {
            btnArr[i]!!.setOnClickListener(listener)
        }
    }

    /**
     * 判断多选按钮的一个按钮是否被选中
     *
     * @param btnArr 多选按钮数组
     * @param index  选中按钮对应的数组角标
     * @return true 被选中 / false 未选中
     */
    fun isSelected(btnArr: Array<Button?>, index: Int): Boolean {
        return btnArr[index]!!.isSelected
    }
}