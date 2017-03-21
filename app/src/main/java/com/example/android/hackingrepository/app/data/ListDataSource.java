package com.example.android.hackingrepository.app.data;

import com.example.android.hackingrepository.api.user.UserModel;

import java.util.List;

import rx.Observable;

/**
 * Data source for List
 *
 * @author pranit
 * @version 1.0
 * @since 21/3/17
 */

public interface ListDataSource {
    Observable<List<UserModel>> getUsers();
    void saveUsers(List<UserModel> users);
    void deleteAll();
}
