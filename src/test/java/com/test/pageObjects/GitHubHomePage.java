package com.test.pageObjects;

import com.test.utils.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GitHubHomePage extends Base {

	public GitHubHomePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		//below line initializes the page element
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@href,'?tab=repositories')]")
	public WebElement lnk_Repositories;

	@FindBy(xpath = "//input[@id='your-repos-filter']")
	public List<WebElement> txt_FindRepository;

	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	public WebElement lnk_Signin;

	public boolean gitHubHomePageIsDisplayed() {
		//WaitUntilElementVisible(lnk_Signin);
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
