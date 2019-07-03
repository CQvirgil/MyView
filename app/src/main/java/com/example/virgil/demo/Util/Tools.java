package com.example.virgil.demo.Util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/*工具类*/
public class Tools {
    private static Tools tools = null;
    private Tools() {
    }

    public static Tools get(){
        if(tools == null){
            synchronized (Tools.class){
                tools = new Tools();
            }
        }
        return tools;
    }

    public DisplayMetrics getDisplayMetrics(Context context){
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return displayMetrics;
    }

    public int getWindowWidth(Context context){
        int width = 0;
        width = getDisplayMetrics(context).widthPixels;
        return width;
    }

    public int getWindowHeight(Context context){
        int height = 0;
        height = getDisplayMetrics(context).heightPixels;
        return height;
    }

    public int gitWindowDpi(Context context){
        return getDisplayMetrics(context).densityDpi;
    }

    public int dp2px(int dp,Context context){
        return dp*getDisplayMetrics(context).densityDpi/160;
    }

}
