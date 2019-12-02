package com.arc.test;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import android.content.Intent;
import android.widget.Toast;


public class WelcomeActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //绑定视图
        setContentView(R.layout.activity_welcome);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Intent 实现跳转  从一个（this）活动跳转到另一个活动
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);

                intent.putExtra("key1", 123456);
                intent.putExtra("key2", "String type");

                //startActivity(intent);
                // 收到返回值
                startActivityForResult(intent, 0x10);
            }
        }, 1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //注意是两个code 别判断错了
        if (requestCode == 0x10) {
            if (resultCode == Activity.RESULT_OK) {
                // B  to A ,A is this
                // 注意是 data 中get
                int v1 = data.getIntExtra("int", 0);//基本数据类型注意给出默认值}
                String v2 = data.getStringExtra("s2");
                Toast.makeText(this, "接收到的参数" + v1 + v2, Toast.LENGTH_SHORT).show();
            }
        }

    }
}
