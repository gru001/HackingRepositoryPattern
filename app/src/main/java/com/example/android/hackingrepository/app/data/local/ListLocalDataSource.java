package com.example.android.hackingrepository.app.data.local;

import com.example.android.hackingrepository.api.user.UserModel;
import com.example.android.hackingrepository.app.data.ListDataSource;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * Description Please
 *
 * @author pranit
 * @version 1.0
 * @since 21/3/17
 */

public class ListLocalDataSource implements ListDataSource{
    private static List<UserModel> sUserModels = new ArrayList<>();

    @Override
    public Observable<List<UserModel>> getUsers() {

        return Observable.from(ListLocalDataSource.sUserModels).toList();
    }

    @Override
    public void saveUsers(final List<UserModel> users){
        ListLocalDataSource.sUserModels.addAll(users);
    }

    @Override
    public void deleteAll() {
        ListLocalDataSource.sUserModels.clear();
    }


}
