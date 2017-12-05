package com.navy.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2017/11/30.
 */

public abstract class BaseActivity<V extends BaseView, P extends BasePresenter<V>> extends AppCompatActivity {
    private V view;
    private P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (presenter == null) {
            presenter = createPresenter();
        }
        if (view == null) {
            view = createView();
        }
        if (presenter != null && view != null) {
            presenter.attachView(view);
        }

    }

    public P getPresenter() {
        return presenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null && view != null) {
            presenter.detachView();
        }
    }

    public abstract P createPresenter();

    public abstract V createView();


}
