package com.navy.http;

import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/8.
 */
public class ResponseBean {
    int code = -11;
    String msg = "";
    Map<String, Object> data = new HashMap<>();
    private String data_json = "";

    public <T> T getBean(Class<T> tClass) {
        if (TextUtils.isEmpty(data_json)) {

            data_json = JSONObject.toJSONString(data);
            Log.e("data_json", data_json);
        }
        return JSONObject.parseObject(data_json, tClass);
    }

    public <T> List<T> getBeanList(Class<T> tClass) {
        if (TextUtils.isEmpty(data_json)) {
            data_json = JSONObject.toJSONString(data);
        }
        return JSONObject.parseArray(data_json, tClass);
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public Map<String, Object> getData() {
        return data;
    }


    public void setData_json(String data_json) {
        this.data_json = data_json;
    }
}
