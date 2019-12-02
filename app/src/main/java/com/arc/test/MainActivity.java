package com.arc.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.time.Instant;
import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //绑定视图
        setContentView(R.layout.activity_main);

        //A to B  ,B is this
//        int v1 = getIntent().getIntExtra("key1",0);//基本数据类型注意给出默认值
//        String v2 = getIntent().getStringExtra("key2");
//        Toast.makeText(this, "接收到的参数" + v1 + v2, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent( );
        intent.putExtra("int", 123456);
        intent.putExtra("s2", "String 啦啦啦");
        setResult(Activity.RESULT_OK,intent);
        //结束当前页面
        finish();
    }


}
