package com.wbacbc.buttontoggle

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


//class MainActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityMainBinding
//    override fun onCreate(savedInstanceState: Bundle?) {
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        super.onCreate(savedInstanceState)
//        setContentView(binding.root)
//    }
//}


class MainActivity : AppCompatActivity(), View.OnClickListener {
    //声明按钮控件和对应id，一定要放入数组，方便操作,有几个按钮，Button数组初始化大小就为多少
    private val twoSelectButton = arrayOfNulls<Button>(2)
    private val twoSelectButtonIds = intArrayOf(R.id._2_btn1, R.id._2_btn2)
    private val threeSelectButton = arrayOfNulls<Button>(3)
    private val threeSelectButtonIds = intArrayOf(R.id._3_btn1, R.id._3_btn2, R.id._3_btn3)
    private val fourSelectButton = arrayOfNulls<Button>(4)
    private val fourSelectButtonIds = intArrayOf(R.id._4_btn1, R.id._4_btn2, R.id._4_btn3, R.id._4_btn4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findView()
        initData()
        setListener()
    }

    private fun findView() {
        SelectButtonUtil.findButton(this, twoSelectButton, twoSelectButtonIds)
        SelectButtonUtil.findButton(this, threeSelectButton, threeSelectButtonIds)
        SelectButtonUtil.findButton(this, fourSelectButton, fourSelectButtonIds)
    }

    private fun initData() {
        setButtonState(this, twoSelectButton, twoSelectButtonIds, 0)
        setButtonState(this, threeSelectButton, threeSelectButtonIds, 0)
        setButtonState(this, fourSelectButton, fourSelectButtonIds, 0)
    }

    private fun setListener() {
        SelectButtonUtil.setListener(this, twoSelectButton, twoSelectButtonIds, this)
        SelectButtonUtil.setListener(this, threeSelectButton, threeSelectButtonIds, this)
        SelectButtonUtil.setListener(this, fourSelectButton, fourSelectButtonIds, this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id._2_btn1 -> setButtonState(this, twoSelectButton, twoSelectButtonIds, 0)
            R.id._2_btn2 -> setButtonState(this, twoSelectButton, twoSelectButtonIds, 1)
            R.id._3_btn1 -> setButtonState(this, threeSelectButton, threeSelectButtonIds, 0)
            R.id._3_btn2 -> setButtonState(this, threeSelectButton, threeSelectButtonIds, 1)
            R.id._3_btn3 -> setButtonState(this, threeSelectButton, threeSelectButtonIds, 2)
            R.id._4_btn1 -> setButtonState(this, fourSelectButton, fourSelectButtonIds, 0)
            R.id._4_btn2 -> setButtonState(this, fourSelectButton, fourSelectButtonIds, 1)
            R.id._4_btn3 -> setButtonState(this, fourSelectButton, fourSelectButtonIds, 2)
            R.id._4_btn4 -> setButtonState(this, fourSelectButton, fourSelectButtonIds, 3)
            else -> {}
        }
    }

    private fun setButtonState(
        activity: Activity,
        btnArr: Array<Button?>,
        idArr: IntArray,
        index: Int
    ) {
        Log.i(
            MainActivity.Companion.TAG,
            "isSelect = " + SelectButtonUtil.isSelected(btnArr, index)
        )
        if (!SelectButtonUtil.isSelected(btnArr, index)) {
            Log.i(MainActivity.Companion.TAG, "into if~")
            SelectButtonUtil.setState(index, activity, btnArr, idArr)
        }
    }

    companion object {
        private const val TAG = "LXP_MainActivity"
    }
}