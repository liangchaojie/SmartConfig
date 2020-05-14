package com.smartconfig;

import android.app.Application;

public class SmartConfigApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SmartRouterUtil.turn2SpecifiedPage(this);
    }
}
