package com.example.android.hackingrepository.api.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserModel {

@SerializedName("name")
@Expose
private String name;
@SerializedName("mobileNumber")
@Expose
private String mobileNumber;

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getMobileNumber() {
return mobileNumber;
}

public void setMobileNumber(String mobileNumber) {
this.mobileNumber = mobileNumber;
}

}