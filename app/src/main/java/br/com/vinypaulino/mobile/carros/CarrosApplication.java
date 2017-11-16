package br.com.vinypaulino.mobile.carros;

import android.app.Application;
import android.util.Log;

/**
 * Created by Naja on 16/11/2017.
 */

public class CarrosApplication extends Application {
    private static final String TAG = "CarrosApplication";
    private static CarrosApplication instance = null;
    public static CarrosApplication getInstance(){
        return instance; //Singleton
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "CarrosApplication.onCreate()");
        instance = this;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.d(TAG, "CarrosApplication.onTerminate()");
    }
}
