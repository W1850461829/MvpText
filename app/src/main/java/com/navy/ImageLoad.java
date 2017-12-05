package com.navy;

import android.widget.ImageView;

/**
 * Created by Administrator on 2017/11/30.
 */

public abstract class ImageLoad {
     protected Object imageloaderObject;
    public abstract ImageLoad  getImageLoaderObject();
    public  abstract ImageLoad setUrl(String url);
    public abstract ImageLoad setround(float f);
    public abstract ImageLoad size(float w,float h);
    public abstract ImageLoad into(ImageView imageView);

}
