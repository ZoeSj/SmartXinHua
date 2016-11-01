package smartxinhua.com.smartxinhua.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 封装的工具类
 * SharedPreferences的封装
 * Created by Zoe on 2016/11/1.
 */
public class PrefUtils {
    public static boolean getBoolean(Context ctx,String key,boolean defValue) {
        //ctx为当前activity的对象.
        SharedPreferences sp = ctx.getSharedPreferences("config",ctx.MODE_PRIVATE);
        return sp.getBoolean(key,defValue);
    }
    public static void setBoolean(Context ctx,String key,boolean value) {
        //ctx为当前activity的对象.
        SharedPreferences sp = ctx.getSharedPreferences("config",ctx.MODE_PRIVATE);
        sp.edit().putBoolean(key,value).commit();
    }
    public static void setString(Context ctx,String key,String value) {
        //ctx为当前activity的对象.
        SharedPreferences sp = ctx.getSharedPreferences("config",ctx.MODE_PRIVATE);
        sp.edit().putString(key,value).commit();
    }
    public static String getString(Context ctx,String key,String defValue) {
        //ctx为当前activity的对象.
        SharedPreferences sp = ctx.getSharedPreferences("config",ctx.MODE_PRIVATE);
        return sp.getString(key,defValue);
    }
    public static void setInt(Context ctx,String key,int value) {
        //ctx为当前activity的对象.
        SharedPreferences sp = ctx.getSharedPreferences("config",ctx.MODE_PRIVATE);
        sp.edit().putInt(key,value).commit();
    }
    public static int getInt(Context ctx,String key,int defValue) {
        //ctx为当前activity的对象.
        SharedPreferences sp = ctx.getSharedPreferences("config",ctx.MODE_PRIVATE);
        return sp.getInt(key,defValue);
    }
}
