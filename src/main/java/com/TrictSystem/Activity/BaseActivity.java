package com.TrictSystem.Activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.TrictSystem.Service.DemoIntentService;
import com.TrictSystem.Service.DemoPushService;
import com.igexin.sdk.PushManager;

/**
 * Created by smile_raccoon on 2017/12/18.
 */

public abstract class BaseActivity extends Activity {

    @Override
    /**
     * 生命周期第一步
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PushManager.getInstance().initialize(this.getApplicationContext(), DemoPushService.class);
        PushManager.getInstance().registerPushIntentService(this.getApplicationContext(), DemoIntentService.class);
        setContentView(getLayout());
        initView();
        initData();
    }

    /**
     * 输入信息的非空判断
     * @param str_1 参数1
     * @param str_2 参数2
     */
    public int Judge_empty(Context context,String str_1,String str_2,String str_1_name,String str_2_name){

        if(str_1.equals("")){
            showToask(context,str_1_name+"不能为空哦!",3);
            return -1;
        }else if(str_2.equals("")){
            showToask(context,str_2_name+"不能为空哦!",3);
            return -1;
        }else{
            return 1;
        }
    }

    /**
     * Toask 公共Toask方法
     * @param context 上下文
     * @param message 需要展示的信息
     * @param during 展示时间
     */
    public void showToask(Context context,String message,int during){
        Toast.makeText(context,message,during).show();
    }

    /**
     * 初始化控件方法
     */
    public abstract void initView();

    /**
     * 初始化数据方法
     */
    public abstract void initData();

    /**
     * 布局文件引入方法
     * @return
     */
    public abstract int getLayout();

}
