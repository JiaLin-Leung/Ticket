package com.TrictSystem.Tools;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by smile_raccoon on 2018/1/17.
 */

public class SpUtils {
    /**
     * 将数据保存在缓冲中
     * @param context
     * @param key
     * @param obj
     */
    public static void save(Context context, String key, Object obj){
        SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        if(obj instanceof String){
            editor.putString(key, (String) obj);
        }else if(obj instanceof Boolean){
            editor.putBoolean(key, (Boolean) obj);
        }
        editor.commit();//保存数据到缓冲
    }
    /**
     * 获取SharedPreferences的实例
     * @param context
     * @return
     */
    public static SharedPreferences get(Context context){

        return context.getSharedPreferences("config", Context.MODE_PRIVATE);
    }

}