package com.example.yinzixuan.project_6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


TextView textview=(TextView)findViewById(R.id.textView);//利用id属性来获取TextView的对象textview
        registerForContextMenu(textview);//长按list元素时系统将调用onCreateContextMenu()方法

    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    public void showPopup(View v){
        PopupMenu popup=new PopupMenu(this,v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.menu_popup);
        popup.show();
    }

    //当注册上下文菜单后收到长按事件时，系统将调用onCreateContextMenu()方法创建菜单
    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_content,menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();

        switch (id){
            case R.id.menu_1:
                Toast.makeText(this,"菜单A已被点击",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_2:
                Toast.makeText(this,"菜单B已被点击",Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    //onContextItemSelected()方法：实现上下文菜单选择
    public boolean onContextItemSelected(MenuItem item){


        switch (item.getItemId()){
            case R.id.menu_1:
                Toast.makeText(this,"上下文菜单1已被点击",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_2:
                Toast.makeText(this,"上下文菜单2已被点击",Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onMenuItemClick(MenuItem menuItem){


        switch (menuItem.getItemId()){
            case R.id.menu_3:
                Toast.makeText(this,"弹出菜单A已被点击",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_4:
                Toast.makeText(this,"弹出菜单B已被点击",Toast.LENGTH_SHORT).show();
                break;
    }
        return false;

}

}
