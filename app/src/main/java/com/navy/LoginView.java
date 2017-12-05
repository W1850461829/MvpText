package com.navy;

import com.navy.base.BaseView;
import com.navy.http.ResponseBean;

/**
 * Created by Administrator on 2017/11/30.
 */

public interface LoginView extends BaseView {
    void loginResult(ResponseBean responseBean);
}
