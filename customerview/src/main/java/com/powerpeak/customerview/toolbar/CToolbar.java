package com.powerpeak.customerview.toolbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.constraint.ConstraintLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.powerpeak.customerview.R;

/**
 * Created by Robin on 2019/12/24.
 * 419109715@qq.com 彬影
 */

public class CToolbar extends ConstraintLayout {

    private TextView tvLocation;
    private TextView tvComplete;
    private TextView tvTitle;
    private TextView tvNum;
    private ImageView ivLocation;
    private ImageView ivBack;
    private int resLocation;
    private int resBack;
    private boolean isShowBack;
    private String title;
    private boolean isShowComplete;
    private boolean isShowLocation;
    private String num;
    private String complete;
    private String location;

    public CToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    //初始化UI，可根据业务需求设置默认值。
    private void initView(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.ypgttoolbar, this, true);
        tvComplete = findViewById(R.id.tv_ypgt_toolbar_complete);
        tvLocation = findViewById(R.id.tv_ypgt_toolbar_location);
        tvNum = findViewById(R.id.tv_ypgt_toolbar_num);
        tvTitle = findViewById(R.id.tv_ypgt_toolbar_title);

        ivLocation = findViewById(R.id.iv_ypgt_toolbar_location);
        ivBack = findViewById(R.id.iv_ypgt_toolbar_back);


        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CToolbar);
        isShowBack = typedArray.getBoolean(R.styleable.CToolbar_isShowToolbarBack, true);
        isShowComplete = typedArray.getBoolean(R.styleable.CToolbar_isShowToolbarComplete, false);
        isShowLocation = typedArray.getBoolean(R.styleable.CToolbar_isShowToolbarLocation, true);

        title = typedArray.getString(R.styleable.CToolbar_toolbarTitleText);
        num = typedArray.getString(R.styleable.CToolbar_toolbarNumText);
        complete = typedArray.getString(R.styleable.CToolbar_toolbarCompleteText);
        location = typedArray.getString(R.styleable.CToolbar_toolbarLocationText);
        resBack = typedArray.getResourceId(R.styleable.CToolbar_toolbarBackImageRes, -1);
        resLocation = typedArray.getResourceId(R.styleable.CToolbar_toolbarLocationImageRes, -1);


        setBackVisible(isShowBack);
        setLocationVisible(isShowLocation);
        setCompleteVisible(isShowComplete);

        setLocationImageRes(resLocation);
        setBackImageRes(resBack);
        tvNum.setText(num);
        tvLocation.setText(location);
        tvComplete.setText(complete);
        tvTitle.setText(title);
    }

    public void setLocationVisible(boolean visible) {
        ivLocation.setVisibility(visible ? VISIBLE : GONE);
        tvLocation.setVisibility(visible ? VISIBLE : GONE);
        tvNum.setVisibility(visible ? VISIBLE : GONE);
    }

    public void setCompleteVisible(boolean visible) {
        tvComplete.setVisibility(visible ? VISIBLE : GONE);
    }

    public void setBackVisible(boolean visible) {
        ivBack.setVisibility(visible ? VISIBLE : GONE);
    }

    public void setLocationImageRes(int res) {
        if (res != -1) {
            ivLocation.setImageResource(res);
        }
    }

    public void setBackImageRes(int res) {
        if (res != -1) {
            ivBack.setImageResource(res);
        }
    }

    public void setNum(String num) {
        if (null != num) {
            tvNum.setText(num);
        }
    }

    public void setLocation(String location) {
        if (location != null) {
            tvLocation.setText(location);
        }
    }

    public void setTitle(String title) {
        if (title != null) {
            tvTitle.setText(title);
        }
    }

    public void setComplete(String complete) {
        if (complete != null) {
            tvComplete.setText(complete);

        }
    }

    public void setOnBackClickListener(OnClickListener listener) {
        ivBack.setOnClickListener(listener);
    }

    public void setOnCompleteClickListener(OnClickListener listener) {
        tvComplete.setOnClickListener(listener);
    }

    public void setOnTitleClickListener(OnClickListener listener) {
        tvTitle.setOnClickListener(listener);
    }

    public void setOnLocationClickListener(OnClickListener listener) {
        tvLocation.setOnClickListener(listener);
        tvNum.setOnClickListener(listener);
        ivLocation.setOnClickListener(listener);
    }
}

