package com.example.android.hackingrepository.app;

import com.example.android.hackingrepository.api.user.UserModel;

import java.util.List;

/**
 * Contract for {@link com.example.android.hackingrepository.app.ListActivity}
 */

public interface ListContract {

    interface View extends BaseView<ListPresenter>{
        void setLoadingIndicator(boolean active);
        void showError();
        void showUsers(List<UserModel> categories);
    }

    interface UserActionListener extends BasePresenter{
        void loadUsers();
    }
}