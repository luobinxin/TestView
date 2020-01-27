package com.powerpeak.testview;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.powerpeak.customerview.dialog.CDialog;
import com.powerpeak.customerview.toolbar.CToolbar;

import cn.com.startai.common.utils.CScreenUtils;
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

    public void btClick(View view) {
//        TAndL.TL("btClick");
//        final CDialog cDialog = new CDialog(this);
//        cDialog.setMessage("即将清空已有数据，原数据自动备份到back目录，是否继续")
//                .setPositive("知道")
//                .setNegative("点错")
//                .setTitle("提示")
//                .setCanceledOut(false)
//                .setOnClickButtonListener(new CDialog.OnClickButtonListener() {
//                    @Override
//                    public void onPositiveClick() {
//                        TAndL.TL("onPositiveClick");
//                        cDialog.dismiss();
//                    }
//
//                    @Override
//                    public void onNegtiveClick() {
//                        TAndL.TL("onPositiveClick");
//                        cDialog.dismiss();
//                    }
//                })
//                .setTextColor(Color.RED)
//                .show();

//        View titleView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.common_dialog_title, null);
        final String[] items = {"拍照", "从相册中选择"};
        new AlertDialog.Builder(this)
//                .setCustomTitle(titleView)
                .setTitle("提示")
                .setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                        TAndL.TL(items[which]);
                    }
                })
                .create().show();


    }

    public void normalDialog(View view) {


        View rootView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.commondialog, null);
        final AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setView(rootView)
                .create();
        Window window = alertDialog.getWindow();
//        View viewById = rootView.findViewById(R.id.tv_cdialog_ok);
//        viewById.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                alertDialog.dismiss();
//            }
//        });


        alertDialog.show();
    }

    public void singleChoose(View view) {

        View titleView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.common_dialog_title, null);
        final String[] items = {"拍照", "从相册中选择"};
        new AlertDialog.Builder(this)
                .setCustomTitle(titleView)
                .setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                        TAndL.TL(items[which]);
                    }
                })
                .create().show();

    }

}
