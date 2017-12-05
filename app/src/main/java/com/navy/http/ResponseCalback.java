package com.navy.http;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.navy.MyApplication;
import com.navy.dialog.ProgressCircle;
import com.navy.util.Util;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/3/8.
 */
public abstract class ResponseCalback extends Callback<ResponseBean> {

    Gson mGson;

    @Override
    public ResponseBean parseNetworkResponse(Response responses, int id) throws Exception {
        String response = responses.body().string();
        Log.e("返回值", response);
        final ResponseBean responseBody = new ResponseBean();
//        ResponseBean responseBean=com.alibaba.fastjson.JSONObject.parseObject(response,ResponseBean.class);
        try {
            JSONObject jsonObject = new JSONObject(response);
            int code = jsonObject.getInt("code");
            String msg = jsonObject.getString("msg");
            JSONObject data = jsonObject.getJSONObject("data");
            responseBody.setCode(code);
            responseBody.setMsg(msg);
            final Map<String, Object> rstList = new HashMap<String, Object>();
            JsonUtil.JsonToHashMap(data, rstList);
            responseBody.setData_json(data.toString());
            responseBody.setData(rstList);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return responseBody;
    }

    public ResponseBean getbean(String json) {
        Type listType = new TypeToken<ResponseBean>() {
        }.getType();
        return gson().fromJson(json, listType);
    }

    private Gson gson() {
        if (mGson == null) {
            mGson = new Gson();
        }
        return mGson;
    }

    @Override
    public void onError(Call call, Exception e, int id) {
        Log.e("excepition", e.toString());
        ProgressCircle.closeLoadingDialog();
        ResponseBean response = new ResponseBean();
        returnData(response);
        Toast.makeText(MyApplication.getInstance().getApplicationContext(), "网络连接失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(ResponseBean response, int id) {
        ProgressCircle.closeLoadingDialog();
        Log.e("response", response.getData().toString());
        if (response.getCode() == 0) {
            if (response.getMsg().equals("该订单已经取消")) {
                Util.show(MyApplication.getInstance().getApplicationContext(), response.getMsg());
            } else {
                Util.show(MyApplication.getInstance().getApplicationContext(), "操作失败");
            }
            returnData(response);
        } else if (response.getCode() == 1) {
            //ToastUtil.show(MyApplication.getInstance().getApplicationContext(), "操作成功");
            returnData(response);
        } else if (response.getCode() == 2) {
            Util.show(MyApplication.getInstance().getApplicationContext(), "参数错误");
            returnData(response);
        } else if (response.getCode() == 3) {
            Util.show(MyApplication.getInstance().getApplicationContext(), "服务器错误");
            returnData(response);
        } else if (response.getCode() == 4) {

            /*Util.show(MyApplication.getInstance().getApplicationContext(), "请重新登录！");
            UserInfoManager.clean(MyApplication.getInstance().getActivity());
            TokenSavemanager.clean(MyApplication.getInstance().getActivity());
            String m = MyApplication.getInstance().getParamAboutApp(SharePrefreName.TYPE);
            OkHttpUtils.getInstance().cancelTag("getdata");*/


            /*if (m.equals("3")) {//用户端

                if (MyApplication.getInstance().getActivity().getClass().getSimpleName().contains("LoginActivity")) {
                    return;
                }

                Intent intent = new Intent();
                intent.setClassName("com.prestolite.saleservice", "com.prestolite.saleservice.activity.activity.MainActivity");
                Intent intent1 = new Intent();
                intent1.setClassName("com.prestolite.saleservice", "com.prestolite.saleservice.activity.activity.LoginActivity");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Intent[] intents = {intent, intent1};
                MyApplication.getInstance().startActivities(intents);
            } else if (m.equals("2")) {//维修端
                if (MyApplication.getInstance().getActivity().getClass().getSimpleName().contains("LoginActivity")) {
                    return;
                }
                Intent intent1 = new Intent();

                intent1.setClassName(MyApplication.getInstance().getApplicationContext(), "com.prestolite.serviceperson.LoginActivity");
                intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent1.putExtra("login", "");
                MyApplication.getInstance().startActivity(intent1);
            } else if (m.equals("1")) {//管理
                if (MyApplication.getInstance().getActivity().getClass().getSimpleName().contains("LoginActivity")) {
                    return;
                }
                Intent intent1 = new Intent();
                intent1.setClassName(MyApplication.getInstance().getApplicationContext(), "com.prestolite.servicemana.activity.LoginActivity");
                intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                Intent[] intents={intent,intent1};
                MyApplication.getInstance().startActivity(intent1);
            }*/
            returnData(response);
        } else if (response.getCode() == 5) {

        /*    Intent intent1 = new Intent();
            intent1.setClass(MyApplication.getInstance().getApplicationContext(), UpDataActivity.class);
            intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                Intent[] intents={intent,intent1};
            Map<String, Object> map = response.getData();
            String url = map.get("url").toString();
            intent1.putExtra("url", url);
            MyApplication.getInstance().startActivity(intent1);
            Util.show(MyApplication.getInstance().getApplicationContext(), "版本过低");*/
            returnData(response);
        }

    }

    public abstract boolean returnData(ResponseBean responseBean);


}
