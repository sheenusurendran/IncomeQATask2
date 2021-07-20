package com.test.utils;

import com.test.services.GitHubServices;

import java.util.Map;

public class FetchServices {

    public static int starsRecievedFromAPI;

    public static String getStars() {
        Map<String, String> repoDetails = GitHubServices.getRepositoryDetails();
        starsRecievedFromAPI = Integer.parseInt(repoDetails.get("noOfStars"));
        int baseLimit = 1000;
        if (starsRecievedFromAPI >= baseLimit) {
            starsRecievedFromAPI = (int) Math.ceil((double) starsRecievedFromAPI / baseLimit);
            return Integer.toString(starsRecievedFromAPI) + "k";
        }
        return Integer.toString(starsRecievedFromAPI);
    }
}
