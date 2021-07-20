package com.test.utils;

public class ResourceAPI {

    public static String path_user = "users/";
    public static String path_repo = "/repos";
    public static String baseURI = "https://api.github.com/";

    /*Below method accepts the gitusername via
    command line and need to pass the value via mvn command*/

    public static String getUserName() {
        return System.getProperty("Git_user");
    }
}

