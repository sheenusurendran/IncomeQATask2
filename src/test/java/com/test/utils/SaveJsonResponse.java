package com.test.utils;

import io.restassured.path.json.JsonPath;

public class SaveJsonResponse {

    public static JsonPath fromRawToJson(String response) {
        JsonPath jsn = new JsonPath(response);
        return jsn;
    }
}
