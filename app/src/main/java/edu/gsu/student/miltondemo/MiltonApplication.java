package edu.gsu.student.miltondemo;

import android.app.Application;

import util.UtilLog;

/**
 * Created by miltonm on 2/6/17.
 */

public class MiltonApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        UtilLog.setDebug(true);
    }
}
