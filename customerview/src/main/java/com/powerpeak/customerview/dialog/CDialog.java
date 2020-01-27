package com.powerpeak.customerview.dialog;

/**
 * Created by Robin on 2019/12/31.
 * 419109715@qq.com 彬影
 */

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.powerpeak.customerview.R;


/**
 * description:自定义dialog
 */

public class CDialog extends Dialog {


    /**
     * 显示的标题
     */
    private TextView titleTv;

    /**
     * 显示的消息
     */
    private TextView messageTv;

    /**
     * 确认和取消按钮
     */
    private Button negativeBn, positiveBn;

    /**
     * 按钮之间的分割线
     */
    private View columnLineView;

    public CDialog(Context context) {
        super(context, R.style.CDialog);
    }

    /**
     * 都是内容数据
     */
    private String message;
    private int colorBtText;
    private String title;
    private String positive, negative;

    /**
     * 底部是否只有一个按钮
     */
    private boolean isSingle = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cdialog);
        //初始化界面控件
        initView();
        //初始化界面数据
        refreshView();
        //初始化界面控件的事件
        initEvent();
    }

    /**
     * 初始化界面的确定和取消监听器
     */
    private void initEvent() {
        //设置确定按钮被点击后，向外界提供监听
        positiveBn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickButtonListener != null) {
                    onClickButtonListener.onPositiveClick();
                }
            }
        });
        //设置取消按钮被点击后，向外界提供监听
        negativeBn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickButtonListener != null) {
                    onClickButtonListener.onNegtiveClick();
                }
            }
        });
    }

    /**
     * 初始化界面控件的显示数据
     */
    private void refreshView() {
        //如果用户自定了title和message
        if (!TextUtils.isEmpty(title)) {
            titleTv.setText(title);
            titleTv.setVisibility(View.VISIBLE);
        } else {
            titleTv.setVisibility(View.GONE);
        }
        if (!TextUtils.isEmpty(message)) {
            messageTv.setText(message);
        }
        //如果设置按钮的文字
        if (!TextUtils.isEmpty(positive)) {
            positiveBn.setText(positive);
        } else {
            positiveBn.setText("确定");
        }
        if (!TextUtils.isEmpty(negative)) {
            negativeBn.setText(negative);
        } else {
            negativeBn.setText("取消");
        }


        /**
         * 只显示一个按钮的时候隐藏取消按钮，回掉只执行确定的事件
         */
        if (isSingle) {
            columnLineView.setVisibility(View.GONE);
            negativeBn.setVisibility(View.GONE);
        } else {
            negativeBn.setVisibility(View.VISIBLE);
            columnLineView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void show() {
        super.show();
        refreshView();
    }


    /**
     * 初始化界面控件
     */
    private void initView() {
        negativeBn = (Button) findViewById(R.id.button2);
        positiveBn = (Button) findViewById(R.id.button1);
        titleTv = (TextView) findViewById(R.id.title);
        messageTv = (TextView) findViewById(R.id.message);
        columnLineView = findViewById(R.id.column_line);
    }

    /**
     * 设置确定取消按钮的回调
     */
    public OnClickButtonListener onClickButtonListener;

    public CDialog setOnClickButtonListener(OnClickButtonListener onClickButtonListener) {
        this.onClickButtonListener = onClickButtonListener;
        return this;
    }

    public interface OnClickButtonListener {
        /**
         * 点击确定按钮事件
         */
        void onPositiveClick();

        /**
         * 点击取消按钮事件
         */
        void onNegtiveClick();
    }

    public String getMessage() {
        return message;
    }

    public CDialog setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public CDialog setCanceledOut(boolean cancel) {
        setCanceledOnTouchOutside(cancel);
        return this;
    }


    public CDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPositive() {
        return positive;
    }

    public CDialog setPositive(String positive) {
        this.positive = positive;
        return this;
    }

    public String getNegative() {
        return negative;
    }

    public CDialog setNegative(String negative) {
        this.negative = negative;
        return this;
    }

    public CDialog setTextColor(int color) {
        colorBtText = color;
        return this;
    }



    public boolean isSingle() {
        return isSingle;
    }

    public CDialog setSingle(boolean single) {
        isSingle = single;
        return this;
    }


}
