package com.example.android_user_registration;
import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;
@ParseClassName("User")
public class User extends ParseObject {
    public ParseUser getUser(){
        return getParseUser("user");
    }

    public void setUser(ParseUser user){
        put("user", user);
    }

}
