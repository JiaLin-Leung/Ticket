package com.TrictSystem.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;

import com.TrictSystem.Beans.User;
import com.TrictSystem.R;
import com.TrictSystem.Tools.SpUtils;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.util.Base64;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by smile_raccoon on 2018/1/17.
 * Created by smile_raccoon on 2018/1/17.
 */

public class MainActivity extends FragmentActivity implements OnGestureListener
{
    public static Fragment[] fragments;
    public static LinearLayout[] linearLayouts;
    public static TextView[] textViews;
    /**定义手势检测实例*/
    public static GestureDetector detector;
    /**做标签，记录当前是哪个fragment*/
    public int MARK=0;
    /**定义手势两点之间的最小距离*/
    final int DISTANT=50;
    private String username;
    private String user_id;
    private String nickname;
    private String user_String;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //分别实例化和初始化fragement、lineatlayout、textview
        setfragment();
        setlinearLayouts();
        settextview();
//        Intent intent=getIntent();
//        username = intent.getStringExtra("user_name");
//        user_id = intent.getStringExtra("user_id");
//        nickname = intent.getStringExtra("nickname");
        //创建手势检测器
        detector=new GestureDetector(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sp = SpUtils.get(MainActivity.this);
        user_String = sp.getString("user_name","");
        nickname = sp.getString("nickname","");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * 初始化Fragment
     */
    public void setfragment()
    {
        fragments=new Fragment[4];
        fragments[0]=getSupportFragmentManager().findFragmentById(R.id.fragment1);
        fragments[1]=getSupportFragmentManager().findFragmentById(R.id.fragment2);
        fragments[2]=getSupportFragmentManager().findFragmentById(R.id.fragment3);
        fragments[3]=getSupportFragmentManager().findFragmentById(R.id.fragment4);
        getSupportFragmentManager().beginTransaction().hide(fragments[0]).hide(fragments[1]).hide(fragments[2]).hide(fragments[3])
                .show(fragments[0]).commit();

    }

    /**
     * 初始化linerlayout
     */
    public void setlinearLayouts()
    {
        linearLayouts=new LinearLayout[4];
        linearLayouts[0]=(LinearLayout)findViewById(R.id.lay1);
        linearLayouts[1]=(LinearLayout)findViewById(R.id.lay2);
        linearLayouts[2]=(LinearLayout)findViewById(R.id.lay3);
        linearLayouts[3]=(LinearLayout)findViewById(R.id.lay4);
        linearLayouts[0].setBackgroundResource(R.drawable.lay_select_bg);
    }

    /**
     * 初始化textview
     */
    public void settextview()
    {
        textViews=new TextView[4];
        textViews[0]=(TextView)findViewById(R.id.fratext1);
        textViews[1]=(TextView)findViewById(R.id.fratext2);
        textViews[2]=(TextView)findViewById(R.id.fratext3);
        textViews[3]=(TextView)findViewById(R.id.fratext4);
        textViews[0].setTextColor(getResources().getColor(R.color.lightseagreen));
    }

    /**
     * 点击底部linerlayout实现切换fragment的效果
     * @param v 控件
     */
    public void LayoutOnclick(View v)
    {
        resetlaybg();//每次点击都重置linearLayouts的背景、textViews字体颜色
        switch (v.getId()) {
            case R.id.lay1:
                getSupportFragmentManager().beginTransaction().hide(fragments[0]).hide(fragments[1]).hide(fragments[2]).hide(fragments[3])
                        .show(fragments[0]).commit();
                linearLayouts[0].setBackgroundResource(R.drawable.lay_select_bg);
                textViews[0].setTextColor(getResources().getColor(R.color.lightseagreen));
                MARK=0;
                break;
            case R.id.lay2:
                getSupportFragmentManager().beginTransaction().hide(fragments[0]).hide(fragments[1]).hide(fragments[2]).hide(fragments[3])
                        .show(fragments[1]).commit();
                linearLayouts[1].setBackgroundResource(R.drawable.lay_select_bg);
                textViews[1].setTextColor(getResources().getColor(R.color.lightseagreen));
                MARK=1;
                break;
            case R.id.lay3:
                getSupportFragmentManager().beginTransaction().hide(fragments[0]).hide(fragments[1]).hide(fragments[2]).hide(fragments[3])
                        .show(fragments[2]).commit();
                linearLayouts[2].setBackgroundResource(R.drawable.lay_select_bg);
                textViews[2].setTextColor(getResources().getColor(R.color.lightseagreen));
                MARK=2;
                break;
            case R.id.lay4:
                getSupportFragmentManager().beginTransaction().hide(fragments[0]).hide(fragments[1]).hide(fragments[2]).hide(fragments[3])
                        .show(fragments[3]).commit();
                linearLayouts[3].setBackgroundResource(R.drawable.lay_select_bg);
                textViews[3].setTextColor(getResources().getColor(R.color.lightseagreen));
                MARK=3;
                break;
            default:
                break;
        }
    }

    /**
     * 重置linearLayouts、textViews
     */
    public void resetlaybg()
    {
        for(int i=0;i<=3;i++)
        {
//            linearLayouts[i].setBackgroundResource(R.drawable.tabfootbg);
            textViews[i].setTextColor(getResources().getColor(R.color.black));
        }

    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        // TODO Auto-generated method stub
//        //将该Activity上触碰事件交给GestureDetector处理
//        return detector.onTouchEvent(event);
//    }
    @Override
    public boolean onDown(MotionEvent arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * 滑动切换效果的实现方法
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     * @return
     */
    @Override
    public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2,
                           float arg3) {
        // TODO Auto-generated method stub
        resetlaybg();
        //当是Fragment0的时候
        if(MARK==0)
        {
            if(arg1.getX()>arg0.getX()+DISTANT)
            {
                getSupportFragmentManager().beginTransaction().hide(fragments[0]).hide(fragments[1]).hide(fragments[2]).hide(fragments[3])
                        .show(fragments[1]).commit();
                linearLayouts[1].setBackgroundResource(R.drawable.lay_select_bg);
                textViews[1].setTextColor(getResources().getColor(R.color.lightseagreen));
                MARK=1;
            }
            else
            {
                linearLayouts[0].setBackgroundResource(R.drawable.lay_select_bg);
                textViews[0].setTextColor(getResources().getColor(R.color.black));
            }

        }
        //当是Fragment1的时候
        else if (MARK==1)
        {
            if(arg1.getX()>arg0.getX()+DISTANT)
            {
                getSupportFragmentManager().beginTransaction().hide(fragments[0]).hide(fragments[1]).hide(fragments[2]).hide(fragments[3])
                        .show(fragments[2]).commit();
                linearLayouts[2].setBackgroundResource(R.drawable.lay_select_bg);
                textViews[2].setTextColor(getResources().getColor(R.color.lightseagreen));
                MARK=2;
            }
            else if(arg0.getX()>arg1.getX()+DISTANT)
            {
                getSupportFragmentManager().beginTransaction().hide(fragments[0]).hide(fragments[1]).hide(fragments[2]).hide(fragments[3])
                        .show(fragments[0]).commit();
                linearLayouts[0].setBackgroundResource(R.drawable.lay_select_bg);
                textViews[0].setTextColor(getResources().getColor(R.color.lightseagreen));
                MARK=0;
            }
            else
            {
                linearLayouts[1].setBackgroundResource(R.drawable.lay_select_bg);
                textViews[1].setTextColor(getResources().getColor(R.color.black));
            }
        }
        //当是Fragment2的时候
        else if(MARK==2)
        {
            if(arg0.getX()>arg1.getX()+DISTANT)
            {
                getSupportFragmentManager().beginTransaction().hide(fragments[0]).hide(fragments[1]).hide(fragments[2])
                        .show(fragments[1]).commit();
                linearLayouts[1].setBackgroundResource(R.drawable.lay_select_bg);
                textViews[1].setTextColor(getResources().getColor(R.color.lightseagreen));
                MARK=1;
            }
            else
            {
                linearLayouts[2].setBackgroundResource(R.drawable.lay_select_bg);
                textViews[2].setTextColor(getResources().getColor(R.color.black));
            }
        }
        return false;
    }

    @Override
    /**
     * 长按方法
     */
    public void onLongPress(MotionEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    /**
     * 滑动时方法
     */
    public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
                            float arg3) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void onShowPress(MotionEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onSingleTapUp(MotionEvent arg0) {
        // TODO Auto-generated method stub
        return false;
    }

}
