package com.example.android.hackingrepository.app;

import android.app.Application;

/**
 * Description Please
 *
 * @author pranit
 * @version 1.0
 * @since 21/3/17
 */

public class RepositoryApplication extends Application{

    private static RepositoryApplication sInstance;

    public RepositoryApplication(){
        sInstance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static RepositoryApplication getInstance(){
        if(sInstance == null){
            throw new UnsupportedOperationException("Application instance is null");
        }

        return sInstance;
    }
}
