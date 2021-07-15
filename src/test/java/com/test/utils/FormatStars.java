package com.test.utils;

import java.util.List;
import com.test.apisetup.GitHubDetails;

public class FormatStars
{
	public static int starsRecievedFromAPI;
	public static String starsAPI;
	
    public static String FindStars()
    {
        List<String> repoStars = GitHubDetails.getGitHubUserDetails();
        starsRecievedFromAPI = Integer.parseInt(repoStars.get(1));
        int baseLimit = 1000;
        if(starsRecievedFromAPI >= baseLimit) {
             starsRecievedFromAPI = (int)Math.ceil((double)starsRecievedFromAPI/baseLimit);
             String starsAPI= Integer.toString(starsRecievedFromAPI)+"k";
             return starsAPI;
        } 
        
        else {
        	return Integer.toString(starsRecievedFromAPI);
        }        	
          
    }
}
