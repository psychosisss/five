package com.example.psychosis.five;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {


    //SharedPreferences 文件名
    private final static String SharedPreferencesFileName="config";

    //键值对
    private final static String Key_Name="Name";//姓名
    private final static String Key_Number="Number";//学号
    private final static String Key_UserType="UserType";

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获得SharedPreferences实例
        preferences=getSharedPreferences(SharedPreferencesFileName,MODE_PRIVATE);
        editor=preferences.edit();
        Button btnwrite=(Button)findViewById(R.id.btn_write);
        Button btnread=(Button)findViewById(R.id.btn_read);

        btnwrite.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                //写入键值对
                editor.putString(Key_Name,"Wang Bowen");
                editor.putString(Key_Number,"19940518");
                editor.putInt(Key_UserType,1);

                //提交修改
                editor.apply();
            }
        });

        btnread.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String strname=preferences.getString(Key_Name,null);
                String strNumber=preferences.getString(Key_Number,null);
                int nType=preferences.getInt(Key_UserType,0);
                if(strname!=null && strNumber!=null)
                    Toast.makeText(MainActivity.this,"名字:"+strname+"学号:"+strNumber+"用户类型:"+
                    nType,Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"无数据",Toast.LENGTH_LONG).show();
            }
        });
    }
}
