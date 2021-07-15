package com.test.utils;

import com.test.services.GitHubDetails;

import java.util.List;

public class FetchFromApi {
    public static int starsRecievedFromAPI;
    public static String starsAPI;

    public static String getStars() {
        List<String> repoStars = GitHubDetails.getGitHubUserDetails();
        starsRecievedFromAPI = Integer.parseInt(repoStars.get(1));
        int baseLimit = 1000;
        if (starsRecievedFromAPI >= baseLimit) {
            starsRecievedFromAPI = (int) Math.ceil((double) starsRecievedFromAPI / baseLimit);
            return Integer.toString(starsRecievedFromAPI) + "k";
        }
        return Integer.toString(starsRecievedFromAPI);
    }
}
