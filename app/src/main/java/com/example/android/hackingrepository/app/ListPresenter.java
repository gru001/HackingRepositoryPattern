package com.example.android.hackingrepository.app;

import com.example.android.hackingrepository.api.user.UserModel;
import com.example.android.hackingrepository.app.data.ListRepository;

import java.util.List;

import rx.Subscriber;

/**
 * Description Please
 *
 * @author pranit
 * @version 1.0
 * @since 21/3/17
 */

public class ListPresenter implements ListContract.UserActionListener{
    private final ListRepository mListRepository;
    private final ListContract.View mView;

    public ListPresenter(ListRepository listRepository, ListContract.View view) {
        mListRepository = listRepository;
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void loadUsers() {
        mView.setLoadingIndicator(true);
        mListRepository.getUsers().subscribe(new Subscriber<List<UserModel>>() {
            @Override
            public void onCompleted() {
                mView.setLoadingIndicator(false);
            }

            @Override
            public void onError(Throwable e) {
                mView.setLoadingIndicator(false);
            }

            @Override
            public void onNext(List<UserModel> userModels) {
                if(!mListRepository.isCached()){
                    mListRepository.saveUsers(userModels);
                    mListRepository.setCached(true);
                }
                mView.showUsers(userModels);
            }
        });
    }

    @Override
    public void onDestroy() {
        mListRepository.setCached(false);
        mListRepository.deleteAll();
    }
}
