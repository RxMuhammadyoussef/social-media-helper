package com.rxmuhammadyoussef.socialmediahelper.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

public class User implements Parcelable {

    private final String userId;
    private final String email;
    private final String userName;

    public User(String userId,
                String userName,
                String email) {
        this.userId = userId;
        this.email = email;
        this.userName = userName;
    }

    @NonNull
    public String getUserId() {
        return userId;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    @NonNull
    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "User ID: " + userId
                .concat("\nEmail: " + email)
                .concat("\nUsername: " + userName);
    }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.userId);
        dest.writeString(this.email);
        dest.writeString(this.userName);
    }

    protected User(Parcel in) {
        this.userId = in.readString();
        this.email = in.readString();
        this.userName = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {return new User(source);}

        @Override
        public User[] newArray(int size) {return new User[size];}
    };
}
