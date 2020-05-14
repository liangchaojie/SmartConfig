package com.smartconfig;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;

/**
 * 用来读取配置中的信息
 */
public class SmartRouterUtil {

    public static void turn2SpecifiedPage(Context context) {
        if (context == null) {
            return;
        }
        String pageName = "";
        String data = "";
        InputStream is = null;
        String msg = null;
        try {
            is = context.getResources().getAssets().open("test.txt");
            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            msg = new String(bytes);
            pageName = msg.substring(msg.indexOf("pageName=") + 9, msg.indexOf("data=")).trim();
            data = msg.substring(msg.indexOf("data=") + 5).trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
        _turn2SpecifiedPage(context, pageName, data);
    }

    private static void _turn2SpecifiedPage(Context context, String pageName, String data) {
        if (context == null || TextUtils.isEmpty(pageName)) {
            return;
        }
        try {
            Class c = Class.forName(pageName);
            Intent intent = new Intent(context, c);
            intent.putExtra("data", data);
            context.startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
