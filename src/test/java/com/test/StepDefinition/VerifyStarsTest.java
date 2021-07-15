package com.test.StepDefinition;

import com.test.pageObjects.GitHubHomePage;
import com.test.pageObjects.GitHubRepoPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.test.utils.FormatStars;

public class VerifyStarsTest {

	private WebDriver driver = Hooks.driver;
	public WebDriverWait wait;

	@Given("^user is on users HomePage$")
	public void user_is_on_users_HomePage() throws Throwable {
		GitHubHomePage homePage = new GitHubHomePage(driver, wait);
		Assert.assertTrue("User is not navigated to git hub home page", homePage.gitHubHomePageIsDisplayed());
	}

	@When("^user clicked on any of the Repo$")
	public void user_clicked_on_any_of_the_Repo() throws Throwable {
		GitHubHomePage homePage = new GitHubHomePage(driver, wait);
		homePage.navigateToRepositories();
		GitHubRepoPage repoPage = new GitHubRepoPage(driver, wait);
		repoPage.getFirstRepoThenNavigateToRepo();

	}

	@Then("^the Stars displayed is matching with the Git Hub API response$")
	public void the_Stars_displayed_is_matching_with_the_Git_Hub_API_response() throws Throwable {
		GitHubRepoPage repoPage = new GitHubRepoPage(driver, wait);
		Assert.assertTrue("Stars displayed on UI is not matching with API",
		repoPage.getStarsFromUI().equalsIgnoreCase(FormatStars.FindStars()));
	}

}
