package com.test.utils;

import java.util.List;
import com.test.apisetup.GitHubDetails;

public class FormatStars
{
    public static String FindStars()
    {
        List<String> repoStars = GitHubDetails.getGitHubUserDetails();
        int starsRecievedFromAPI = Integer.parseInt(repoStars.get(1));
        int baseLimit = 1000;
        if(starsRecievedFromAPI >= baseLimit) {
            starsRecievedFromAPI = Math.round(starsRecievedFromAPI/baseLimit);
        } String starsAPI= Integer.toString(starsRecievedFromAPI);
        System.out.println(starsAPI);
            return starsAPI;
    }
}
