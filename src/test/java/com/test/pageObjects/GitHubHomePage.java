package com.test.pageObjects;

import com.test.utils.Base;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GitHubHomePage extends Base {
	public GitHubHomePage(WebDriver driver, WebDriverWait wait) {

		super(driver, wait);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@href,'?tab=repositories')]")
	private WebElement lnk_Repositories;

	@FindBy(xpath = "//input[@id='your-repos-filter']")
	private List<WebElement> txt_FindRepository;

	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	private WebElement lnk_Signin;

	public boolean gitHubHomePageIsDisplayed() {
		return lnk_Signin.isDisplayed();
	}

	public void navigateToRepositories() {
		int Size = txt_FindRepository.size();
		if (Size == 0) {
			if (lnk_Repositories.isDisplayed()) {
				lnk_Repositories.click();
			}
		}

	}
}
