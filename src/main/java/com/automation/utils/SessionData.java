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

    private static String accountFrom;
    private static String accountTo;
    private static double transferAmount;
    private static double initialFromBalance;
    private static double initialToBalance;

    public static void setTransferContext(String from, String to, double amount, double initFrom, double initTo) {
        accountFrom = from;
        accountTo = to;
        transferAmount = amount;
        initialFromBalance = initFrom;
        initialToBalance = initTo;
    }

    public static String getAccountFrom() {
        return accountFrom;
    }

    public static String getAccountTo() {
        return accountTo;
    }

    public static double getTransferAmount() {
        return transferAmount;
    }

    public static double getInitialFromBalance() {
        return initialFromBalance;
    }

    public static double getInitialToBalance() {
        return initialToBalance;
    }
}

