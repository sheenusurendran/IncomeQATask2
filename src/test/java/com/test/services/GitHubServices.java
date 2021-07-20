package com.test.services;

import com.test.pageObjects.GitHubRepoPage;
import com.test.utils.Formatter;
import com.test.utils.ResourceAPI;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.util.HashMap;
import java.util.Map;

public class GitHubServices {

	public static String response;
	public static String gitUserName = ResourceAPI.getUserName();
	public static String basePathRepo = ResourceAPI.path_user + gitUserName + ResourceAPI.path_repo;
	public static String baseURI = ResourceAPI.baseURI;
	public static String repoName = GitHubRepoPage.repoName;

	public static Map<String, String> getRepositoryDetails() {

		String repoNameFromAPI = null;
		String noOfStars = null;
		Map<String, String> hashmap = new HashMap<String, String>();
		response = RestAssured.given().baseUri(baseURI)
				.when().get(basePathRepo)
				.then().assertThat().statusCode(200)
				.extract().response().asString();
		JsonPath repoDetails = Formatter.fromRawToJson(response);

		int noofRepos = repoDetails.getInt("name.size()");
		for (int repoIndex = 0; repoIndex < noofRepos; repoIndex++) {
			if (repoDetails.get("name[" + repoIndex + "]").toString().equalsIgnoreCase(repoName)) {
				repoNameFromAPI = repoDetails.get("name[" + repoIndex + "]");
				noOfStars = repoDetails.get("stargazers_count[" + repoIndex + "]").toString();
			}
		}
		hashmap.put("repoName", repoNameFromAPI);
		hashmap.put("noOfStars", noOfStars);
		return hashmap;
	}
}
