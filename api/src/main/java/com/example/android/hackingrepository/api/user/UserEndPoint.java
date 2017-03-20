package com.example.android.hackingrepository.api.user;

import com.example.android.hackingrepository.api.ApiConstants;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Description Please
 *
 * @author pranit
 * @version 1.0
 * @since 21/3/17
 */

public interface UserEndPoint {
    @GET(ApiConstants.API_USERS)
    Observable<List<UserModel>> getUsers();
}
