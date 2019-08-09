package kg.pharma;

import android.app.Activity;
import android.app.Application;

public class App extends Application {
    private static App instance;
    public static Activity activity;


    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}