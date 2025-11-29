package com.automation.utils;

import com.automation.models.UserData;

public class SessionData {
    private static UserData currentUser;

    public static void setCurrentUser(UserData user) {
        currentUser = user;
    }

    public static UserData getCurrentUser() {
        return currentUser;
    }
}
