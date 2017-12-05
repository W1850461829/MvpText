package com.navy.dialog;


import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.widget.ImageView;

import com.navy.mvptext.R;


public class CustomProgressDialog extends Dialog {
	private Context context = null;

	public CustomProgressDialog(Context context) {
		super(context, R.style.CustomProgressDialog);
		this.context = context;
		setContentView(R.layout.bus_customprogressdialog);
		getWindow().getAttributes().gravity = Gravity.CENTER;
		setCanceledOnTouchOutside(false);
	}

	public CustomProgressDialog(Context context, int theme) {
		super(context, R.style.CustomProgressDialog);
		this.context = context;
		setContentView(R.layout.bus_customprogressdialog);
		getWindow().getAttributes().gravity = Gravity.CENTER;
		setCanceledOnTouchOutside(false);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		super.show();
		ImageView imageView = (ImageView) this.findViewById(R.id.loadingImageView);
		AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
		animationDrawable.start();

	}

}
