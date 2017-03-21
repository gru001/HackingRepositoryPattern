package com.example.android.hackingrepository.app.data.net;

import com.example.android.hackingrepository.api.RetroFitFactory;
import com.example.android.hackingrepository.api.user.UserEndPoint;
import com.example.android.hackingrepository.api.user.UserModel;
import com.example.android.hackingrepository.app.data.ListDataSource;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Description Please
 *
 * @author pranit
 * @version 1.0
 * @since 21/3/17
 */

public class ListNetDataSource implements ListDataSource {
    @Override
    public Observable<List<UserModel>> getUsers() {
        final Observable<List<UserModel>> observable = RetroFitFactory.get().create(UserEndPoint.class).getUsers();
        return observable.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
    }

    @Override
    public void saveUsers(List<UserModel> users) {

    }

    @Override
    public void deleteAll() {

    }
}
