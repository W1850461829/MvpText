package com.navy.base;

import com.navy.LoginView;
import com.navy.http.HttpPush;
import com.navy.http.ResponseBean;
import com.navy.http.ResponseCalback;

import java.util.Map;

/**
 * Created by Administrator on 2017/11/29.
 */

public class LoginMode {
    public void login(String name, String password, final LoginView loginView) {
        HttpPush.post().url().addParams().addParams().build().execute(new ResponseCalback() {
            @Override
            public boolean returnData(ResponseBean responseBean) {
                loginView.loginResult(responseBean);
                return false;

            }
        });

    }
}
