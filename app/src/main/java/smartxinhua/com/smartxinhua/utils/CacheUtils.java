package smartxinhua.com.smartxinhua.utils;

import android.content.Context;

/**
 * 网络缓存的工具类
 * Created by Zoe on 2016/11/4.
 */
public class CacheUtils {
    /**
     * 以url为key,以json为value,保存为本地
     * 也可以用文件缓存?以MD5(url)为文件名,以json为文件内容
     */
    public static void setCache(String url, String json, Context ctx)
    {
        PrefUtils.setString(ctx,url,json);
    }

    /**
     * 获取缓存
     * @param url
     * @param ctx
     * @return
     * 文件缓存,查找一个文件有没有叫做MD5(url),有的话,说明有缓存
     */
    public static String getCache(String url,Context ctx){
        return PrefUtils.getString(ctx,url,null);
    }
}
