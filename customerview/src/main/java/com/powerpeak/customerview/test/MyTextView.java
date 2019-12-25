package com.powerpeak.customerview.test;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.powerpeak.customerview.R;


/**
 * Created by Robin on 2019/12/24.
 * 419109715@qq.com 彬影
 */

public class MyTextView extends View {
    private final String TAG = "MyTextView";

    public MyTextView(Context context) {
        super(context);
    }


    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyTextView);
        String string = typedArray.getString(R.styleable.MyTextView_text);
        int integer = typedArray.getInteger(R.styleable.MyTextView_testAttr, -1);
        String msg = "String = " + string + " integer = " + integer;
        Log.e(TAG, msg);
        typedArray.recycle();
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

}
