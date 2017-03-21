package com.example.android.hackingrepository.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.android.hackingrepository.api.user.UserModel;
import com.example.android.hackingrepository.app.data.ListRepository;
import com.example.android.hackingrepository.app.data.local.ListLocalDataSource;
import com.example.android.hackingrepository.app.data.net.ListNetDataSource;
import com.example.android.hackingrepository.app.utils.DividerItemDecoration;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListActivity extends AppCompatActivity implements ListContract.View, UsersListAdapter.ItemClickListener{
    @BindView(R.id.rvUsers) RecyclerView rvUsers;
    @BindView(R.id.pbLoader) ProgressBar pbLoader;

    private UsersListAdapter mListAdapter;
    private ListContract.UserActionListener mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);

        new ListPresenter(ListRepository.getInstance(new ListNetDataSource(), new ListLocalDataSource()),this);

        // initialize view
        mListAdapter = new UsersListAdapter(this);
        rvUsers.setAdapter(mListAdapter);
        rvUsers.addItemDecoration(new DividerItemDecoration(this));
        rvUsers.setHasFixedSize(true);
        rvUsers.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.loadUsers();
    }

    @Override
    public void setPresenter(ListPresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if(active){
            pbLoader.setVisibility(View.VISIBLE);
        }else{
            pbLoader.setVisibility(View.GONE);
        }
    }

    @Override
    public void showError() {
        Toast.makeText(this,"Something went wrong",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUsers(List<UserModel> users) {
        mListAdapter.setUsersList(users);
        mListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int pos) {
        Toast.makeText(this,"Item Click",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }
}
