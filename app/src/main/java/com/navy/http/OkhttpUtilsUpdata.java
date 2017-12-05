package com.navy.http;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.PostFileBuilder;
import com.zhy.http.okhttp.builder.PostFormBuilder;

import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2017/12/4.
 */

public class OkhttpUtilsUpdata extends OkHttpUtils {
    public OkhttpUtilsUpdata(OkHttpClient okHttpClient) {
        super(okHttpClient);
    }

    public static PostFormBuilder post(String token, String userid, String version) {
        PostFormBuilder postFormBuilder = new PostFormBuilder();
        postFormBuilder.addHeader("X-Auth-Token", token);
        postFormBuilder.addHeader("X-Auth-UserId", userid);
        postFormBuilder.addHeader("X-Auth-Version", version);
        return postFormBuilder;
    }
    public static PostFileBuilder postFile(String token, String userid, String version) {
        PostFileBuilder postFormBuilder = new PostFileBuilder();
        postFormBuilder.addHeader("X-Auth-Token", token);
        postFormBuilder.addHeader("X-Auth-UserId", userid);
        postFormBuilder.addHeader("X-Auth-Version", version);
        return postFormBuilder;
    }

}
