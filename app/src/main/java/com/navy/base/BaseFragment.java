package com.navy.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.navy.mvptext.R;

/**
 * Created by Administrator on 2017/11/30.
 */

public abstract class BaseFragment<V extends BaseView, P extends BasePresenter<V>> extends Fragment {
    private V view;
    private P presenter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null && view != null) {
            presenter.detachView();
        }
    }

    public P getPresenter() {
        return presenter;
    }

    public abstract P createPresenter();

    public abstract V createView();
}
