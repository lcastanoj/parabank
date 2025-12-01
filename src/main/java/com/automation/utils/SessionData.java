package com.automation.utils;

import com.automation.models.UserData;

public class SessionData {
    private static UserData currentUser;
    private static String createdAccount;

    public static void setCurrentUser(UserData user) {
        currentUser = user;
    }

    public static UserData getCurrentUser() {
        return currentUser;
    }

    public static void setCreatedAccount(String account) {
        createdAccount = account;
    }

    public static String getCreatedAccount() {
        return createdAccount;
    }
}
