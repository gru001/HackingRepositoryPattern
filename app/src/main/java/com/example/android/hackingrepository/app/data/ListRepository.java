package com.example.android.hackingrepository.app.data;

import android.support.annotation.NonNull;

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

    public ListRepository(@NonNull ListDataSource netDataSource) {
        mNetDataSource = netDataSource;
    }

    public static ListRepository getInstance(ListDataSource netDataSource){
        if(sInstance == null){
            sInstance = new ListRepository(netDataSource);
        }

        return sInstance;
    }


    @Override
    public Observable<List<UserModel>> getUsers() {
        return mNetDataSource.getUsers();
    }
}
