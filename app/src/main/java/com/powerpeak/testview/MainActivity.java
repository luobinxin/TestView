package com.powerpeak.testview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.powerpeak.customerview.toolbar.CToolbar;

import cn.com.startai.common.utils.CThreadPoolUtils;
import cn.com.startai.common.utils.TAndL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CToolbar ctb = findViewById(R.id.ctb);

        ctb.setOnTitleClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TAndL.TL("title click");
            }
        });

        ctb.setOnBackClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TAndL.TL("back click");
            }
        });

        ctb.setOnLocationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TAndL.TL("location click");
            }
        });

        ctb.setOnCompleteClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TAndL.TL("complete click");
            }
        });

    }
}
