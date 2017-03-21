package com.example.android.hackingrepository.app.data;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.android.hackingrepository.api.user.UserModel;

import java.util.List;

import rx.Observable;

/**
 * Repository for user list
 *
 * @author pranit
 * @version 1.0
 * @since 21/3/17
 */

public class ListRepository implements ListDataSource{
    private static ListRepository sInstance;
    @NonNull private final ListDataSource mNetDataSource;
    @NonNull private final ListDataSource mLocalDataSource;
    private boolean isCached = false;

    public static final String TAG = ListRepository.class.getSimpleName();

    public ListRepository(@NonNull ListDataSource netDataSource, @NonNull ListDataSource localDataSource) {
        mNetDataSource = netDataSource;
        mLocalDataSource = localDataSource;
    }

    public boolean isCached() {
        return isCached;
    }

    public void setCached(boolean cached) {
        isCached = cached;
    }

    public static ListRepository getInstance(ListDataSource netDataSource, ListDataSource localDataSource){
        if(sInstance == null){
            sInstance = new ListRepository(netDataSource, localDataSource);
        }

        return sInstance;

    }


    @Override
    public Observable<List<UserModel>> getUsers() {
        if(!isCached()){
            Log.i(TAG, "getUsers: from net");
            return mNetDataSource.getUsers();
        }

        Log.i(TAG, "getUsers: from local");
        return mLocalDataSource.getUsers();
    }

    @Override
    public void saveUsers(List<UserModel> users) {
        mLocalDataSource.saveUsers(users);
    }

    @Override
    public void deleteAll() {
        mLocalDataSource.deleteAll();
    }
}
