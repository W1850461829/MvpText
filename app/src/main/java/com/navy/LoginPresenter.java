package com.navy;

import com.navy.base.BasePresenter;
import com.navy.base.LoginMode;
import com.navy.http.ResponseBean;

/**
 * Created by Administrator on 2017/11/30.
 */

public class LoginPresenter extends BasePresenter<LoginView> {
    private LoginMode loginMode;


    public LoginPresenter() {
        loginMode = new LoginMode();
    }


    public void login(String name, String password) {
        if (getView() != null) {
            loginMode.login(name, password, new LoginView() {
                @Override
                public void loginResult(ResponseBean responseBean) {
                    if (getView() != null) {
                        getView().loginResult(responseBean);
                    }
                }

            });

        }

    }


}
