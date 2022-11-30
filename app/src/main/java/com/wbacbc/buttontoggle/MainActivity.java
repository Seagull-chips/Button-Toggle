package com.wbacbc.buttontoggle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "LXP_MainActivity";

    //声明按钮控件和对应id，一定要放入数组，方便操作,有几个按钮，Button数组初始化大小就为多少
    private Button[] twoSelectButton = new Button[2];
    private int[] twoSelectButtonIds = new int[]{R.id._2_btn1, R.id._2_btn2};


    private Button[] threeSelectButton = new Button[3];
    private int[] threeSelectButtonIds = new int[]{R.id._3_btn1, R.id._3_btn2, R.id._3_btn3};

    private Button[] fourSelectButton = new Button[4];
    private int[] fourSelectButtonIds = new int[]{R.id._4_btn1, R.id._4_btn2, R.id._4_btn3, R.id._4_btn4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();

        initData();

        setListener();

    }

    private void findView() {
        SelectButtonUtil.findButton(this, twoSelectButton, twoSelectButtonIds);
        SelectButtonUtil.findButton(this, threeSelectButton, threeSelectButtonIds);
        SelectButtonUtil.findButton(this, fourSelectButton, fourSelectButtonIds);
    }

    private void initData() {
        setButtonState(this, twoSelectButton, twoSelectButtonIds, 0);
        setButtonState(this, threeSelectButton, threeSelectButtonIds, 0);
        setButtonState(this, fourSelectButton, fourSelectButtonIds, 0);
    }

    private void setListener() {
        SelectButtonUtil.setListener(this, twoSelectButton, twoSelectButtonIds, this);
        SelectButtonUtil.setListener(this, threeSelectButton, threeSelectButtonIds, this);
        SelectButtonUtil.setListener(this, fourSelectButton, fourSelectButtonIds, this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id._2_btn1:
                setButtonState(this, twoSelectButton, twoSelectButtonIds, 0);
                break;
            case R.id._2_btn2:
                setButtonState(this, twoSelectButton, twoSelectButtonIds, 1);
                break;
            case R.id._3_btn1:
                setButtonState(this, threeSelectButton, threeSelectButtonIds, 0);
                break;
            case R.id._3_btn2:
                setButtonState(this, threeSelectButton, threeSelectButtonIds, 1);
                break;
            case R.id._3_btn3:
                setButtonState(this, threeSelectButton, threeSelectButtonIds, 2);
                break;
            case R.id._4_btn1:
                setButtonState(this, fourSelectButton, fourSelectButtonIds, 0);
                break;
            case R.id._4_btn2:
                setButtonState(this, fourSelectButton, fourSelectButtonIds, 1);
                break;
            case R.id._4_btn3:
                setButtonState(this, fourSelectButton, fourSelectButtonIds, 2);
                break;
            case R.id._4_btn4:
                setButtonState(this, fourSelectButton, fourSelectButtonIds, 3);
                break;
            default:
                break;
        }
    }

    private void setButtonState(Activity activity, Button[] btnArr, int[] idArr, int index) {
        Log.i(TAG, "isSelect = " + SelectButtonUtil.isSelected(btnArr, index));
        if (!SelectButtonUtil.isSelected(btnArr, index)) {
            Log.i(TAG, "into if~");
            SelectButtonUtil.setState(index, activity, btnArr, idArr);
        }
    }
}