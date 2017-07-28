package com.dfexamples.store_practice.Enums;

public enum TestUser {

    USER_W_GOOD_INFO("df012668+auto01@gmail.com","tester1"),
    USER_W_BAD_PWD("df012668+auto01@gmail.com","wrongpassword"),
    USER_W_BAD_LOGIN("wrongusername","tester1");

    String username;
    String password;

    private TestUser(String username_to_login_with, String password_to_login_with) {
        this.username = username_to_login_with;
        this.password = password_to_login_with;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
