package com.navy.http;


import android.app.Activity;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.PostFileBuilder;
import com.zhy.http.okhttp.builder.PostFormBuilder;

/**
 * Created by Administrator on 2017/1/6.
 */
public class HttpPush {

    private HttpPush() {
    }

    public static PostFormBuilder post(Activity activity){
        /*String token= TokenSavemanager.token(activity);
        String userid=TokenSavemanager.userId(activity);
        String version= Util.getVersionName(activity);*/

        return OkhttpUtilsUpdata.post("1","1","1");
    }
    public static PostFileBuilder postFile(Activity activity){
       /* String token= TokenSavemanager.token(activity);
        String userid=TokenSavemanager.userId(activity);
        String version= Util.getVersionName(activity);
*/
        return OkhttpUtilsUpdata.postFile("1","1","1");
    }

}
