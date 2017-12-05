package com.navy.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/12/4.
 */

public class Util {
    public static void show(Context context, String info) {
        Toast.makeText(context, info, Toast.LENGTH_LONG).show();
    }
}
