package com.example.android.hackingrepository.app;

/**
 * Base View for all view
 */

public interface BaseView<T extends BasePresenter> {
    void setPresenter(T presenter);
}
