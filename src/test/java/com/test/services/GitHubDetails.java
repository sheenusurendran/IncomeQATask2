package com.test.services;

import com.test.pageObjects.GitHubRepoPage;
import com.test.utils.Formatter;
import com.test.utils.ResourceAPI;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.util.Arrays;
import java.util.List;

public class GitHubDetails {

	public static String response;
	public static String gitUserName = ResourceAPI.getUserName();
	public static String basePathRepo = ResourceAPI.path_user + gitUserName + ResourceAPI.path_repo;
	public static String baseURI = ResourceAPI.baseURI;
	public static JsonPath jsn = null;
	public static String repoName = GitHubRepoPage.repoName;

	public static List<String> getGitHubUserDetails() {

		String repoNameFromAPI = null;
		String noOfStars = null;
		response = RestAssured.given().baseUri(baseURI)
				.when().get(basePathRepo)
				.then().assertThat().statusCode(200)
				.extract().response().asString();
		JsonPath repoDetails = Formatter.fromRawToJson(response);

		int noofRepos = repoDetails.getInt("name.size()");
		for (int i = 0; i < noofRepos; i++) {
			if (repoDetails.get("name[" + i + "]").toString().equalsIgnoreCase(repoName)) {
				repoNameFromAPI = repoDetails.get("name[" + i + "]");
				noOfStars = repoDetails.get("stargazers_count[" + i + "]").toString();
			}
		}
		return Arrays.asList(repoNameFromAPI, noOfStars);
	}
}
