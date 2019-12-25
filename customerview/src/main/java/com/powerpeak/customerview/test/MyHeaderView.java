package com.powerpeak.customerview.test;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.powerpeak.customerview.R;

public class MyHeaderView extends RelativeLayout {

    private ImageView img_left;
    private ImageView img_right;
    private TextView text_center;
    private RelativeLayout layout_root;

    public MyHeaderView(Context context) {
        super(context);
    }

    public MyHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public MyHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //初始化UI，可根据业务需求设置默认值。
    private void initView(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.myheadview, this, true);
        img_left = (ImageView) findViewById(R.id.header_left_img);
        img_right = (ImageView) findViewById(R.id.header_right_img);
        text_center = (TextView) findViewById(R.id.header_center_text);
        layout_root = (RelativeLayout) findViewById(R.id.header_root_layout);
        layout_root.setBackgroundColor(Color.BLACK);
        text_center.setTextColor(Color.WHITE);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyHeaderView);
        boolean isShowTitle = typedArray.getBoolean(R.styleable.MyHeaderView_isShowTitle, true);
        String title = typedArray.getString(R.styleable.MyHeaderView_titleText);
        int rightResourceId = typedArray.getResourceId(R.styleable.MyHeaderView_rightImage,-1);
        int leftResourceId = typedArray.getResourceId(R.styleable.MyHeaderView_rightImage,-1);

        text_center.setVisibility(isShowTitle ? VISIBLE : INVISIBLE);
        text_center.setText(title);

        img_right.setImageResource(rightResourceId);
        img_left.setImageResource(leftResourceId);

    }

    //设置标题文字的方法
    private void setTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
            text_center.setText(title);
        }
    }

    //对左边按钮设置事件的方法
    private void setLeftListener(OnClickListener onClickListener) {
        img_left.setOnClickListener(onClickListener);
    }

    //对右边按钮设置事件的方法
    private void setRightListener(OnClickListener onClickListener) {
        img_right.setOnClickListener(onClickListener);
    }
}