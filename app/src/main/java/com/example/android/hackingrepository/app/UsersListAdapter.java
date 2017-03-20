package com.example.android.hackingrepository.app;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.hackingrepository.api.user.UserModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Adapter for users List
 */

public class UsersListAdapter extends RecyclerView.Adapter<UsersListAdapter.ListUsersHolder> {

    private List<UserModel> mUsers;
    private ItemClickListener itemClickListener;

    public UsersListAdapter(List<UserModel> users, ItemClickListener itemClickListener){
        mUsers =new ArrayList<>();
        mUsers = users;
        this.itemClickListener=itemClickListener;
    }

    public UsersListAdapter(ItemClickListener itemClickListener) {
        this.mUsers = Collections.emptyList();
        this.itemClickListener=itemClickListener;
    }

    public void setUsersList(List<UserModel> userList) {
        this.mUsers = userList;
    }

    public List<UserModel> getmUserList() {
        return mUsers;
    }

    @Override
    public ListUsersHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ListUsersHolder listUsersHolder = new ListUsersHolder(v);
        return listUsersHolder;
    }

    @Override
    public void onBindViewHolder(ListUsersHolder holder, int position) {
        final UserModel userModel = mUsers.get(position);
        holder.lblName.setText(userModel.getName());
        holder.lblMobile.setText(userModel.getMobileNumber());
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public class ListUsersHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.lblName) TextView lblName;
        @BindView(R.id.lblMobileNumber) TextView lblMobile;

        public ListUsersHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            itemClickListener.onItemClick(getAdapterPosition());
        }
    }

    public interface ItemClickListener{
        public void onItemClick(int pos);

    }
}