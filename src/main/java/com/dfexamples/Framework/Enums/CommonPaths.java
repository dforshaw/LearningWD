package com.dfexamples.Framework.Enums;

public enum CommonPaths {
    USER_HOME_DIRECTORY(System.getProperty("user.home"));

    String path;

    private CommonPaths(String path_to_use) {
        this.path = path_to_use;
    }

    public String getPath() {
        return path;
    }
}
