package com.navy.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;


/**
 * Created by jiang on 2017/2/7.
 */

public class ProgressCircle {
    private static volatile ProgressCircle progressCircle;
    private static CustomProgressDialog customProgressDialog;


    public static void showLoadingDialog(Context context) {
        if (customProgressDialog == null) {
            customProgressDialog = new CustomProgressDialog(context);
            customProgressDialog.show();
            customProgressDialog.setOnKeyListener(
                    new DialogInterface.OnKeyListener() {
                        @Override
                        public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent keyEvent) {
                            if (keyCode == KeyEvent.KEYCODE_BACK
                                    && keyEvent.getRepeatCount() == 0) {
                                return true;
                            }
                            return false;
                        }
                    }
            );

        }
    }

    public static void closeLoadingDialog() {
        if (customProgressDialog != null) {
            if (customProgressDialog.isShowing()) {
                customProgressDialog.dismiss();
            }
            customProgressDialog = null;
        }
    }
}
