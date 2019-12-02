package com.arc.test;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class TestViewActivity extends Activity  implements  View.OnClickListener  {
    private EditText input1;
    private ProgressBar processBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //绑定视图
        setContentView(R.layout.activity_test_view);
//b1
        findViewById(R.id.b1).setOnClickListener(this);
          input1 =(EditText) findViewById(R.id.input1);
          processBar = findViewById(R.id.process1);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.b1) {
            Editable text = input1.getText();
            Toast.makeText(this, "=-=  \n"+text.toString(), Toast.LENGTH_SHORT).show();

            int progress = processBar.getProgress();
            progress += 10;
            if (progress > 100) {
                progress = 0;
            }
        }
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        //返回时拦截
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("确认退出吗");
        builder.setMessage("退出");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //点击后的操作

            }

        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //取消
                dialog.dismiss();
            }
        });
        builder.show();
    }
}
