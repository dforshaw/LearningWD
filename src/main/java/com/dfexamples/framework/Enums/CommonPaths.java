package com.dfexamples.framework.Enums;

public enum CommonPaths {
    USER_HOME_DIRECTORY(System.getProperty("user.home")),
    CODE_DIRECTORY_HOME("/Code"),
    CODE_DIRECTORY_WORK("/IdeaProjects");

    String path;

    private CommonPaths(String path_to_use) {
        this.path = path_to_use;
    }

    public String getPath() {
        return path;
    }
}
