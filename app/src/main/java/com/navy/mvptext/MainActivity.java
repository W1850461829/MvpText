package com.navy.mvptext;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.navy.ImageLoad;
import com.navy.LoginPresenter;
import com.navy.LoginView;
import com.navy.base.BaseActivity;
import com.navy.http.ResponseBean;

public class MainActivity extends BaseActivity<LoginView, LoginPresenter> implements LoginView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void clickLogin(View view) {

        if (getPresenter() != null) {
            getPresenter().login(   "dream", "123456");
        }

    }

    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    public LoginView createView() {
        return this;
    }


    @Override
    public void loginResult(ResponseBean responseBean) {


    }
}
