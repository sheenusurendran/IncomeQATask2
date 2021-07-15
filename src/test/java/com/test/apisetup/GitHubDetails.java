package com.test.apisetup;

import com.test.utils.SaveJsonResponse;
import com.test.utils.SetupResourceAPI;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import java.util.Arrays;
import java.util.List;
import com.test.pageObjects.GitHubRepoPage;
import static io.restassured.RestAssured.given;

    public  class GitHubDetails {

        public static String response;
        public static String gitUserName = SetupResourceAPI.getUserName();
        public static String basepathUser = SetupResourceAPI.path_user + gitUserName;
        public static String basePathRepo = SetupResourceAPI.path_user + gitUserName + SetupResourceAPI.path_repo;
        public static String baseURI = SetupResourceAPI.baseURI;
        public static JsonPath jsn = null;
        public static String repoName = GitHubRepoPage.repoName;

        public static List<String> getGitHubUserDetails() {
            String repoNameFromAPI= null;
            String noOfStars =null;
            response = RestAssured.given().baseUri(baseURI).when().get(basePathRepo).then().assertThat().statusCode(200).extract()
                    .response().asString();
            JsonPath jsn = SaveJsonResponse.fromRawToJson(response);
            int noofRepos = jsn.getInt("name.size()");
           // String nameofRepo = jsn.get("name[" + 1 + "]");
            //String noofStars = jsn.get("stargazers_count[" + 1 + "]");
            //String noofStars = "913578";
           // return Arrays.asList(nameofRepo, noofStars);*/

            for (int i = 0; i < noofRepos; i++) {
                if ( jsn.get("name[" + i + "]").toString().equalsIgnoreCase(repoName)){
                     repoNameFromAPI = jsn.get("name[" + i + "]");
                    noOfStars = jsn.get("stargazers_count[" + i + "]").toString();
                }
            }
            return Arrays.asList(repoNameFromAPI, noOfStars);
        }
    }

