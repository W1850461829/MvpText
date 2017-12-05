package com.navy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.navy.base.BaseFragment;
import com.navy.mvptext.R;

/**
 * Created by Administrator on 2017/11/30.
 */

public class MainFragment extends BaseFragment<LoginView, LoginPresenter> {
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getPresenter() != null) {
                    getPresenter().login("dream", "123456");

                }
            }
        });
    }

    @Override
    public LoginPresenter createPresenter() {
        return null;
    }

    @Override
    public LoginView createView() {
        return null;
    }
}
