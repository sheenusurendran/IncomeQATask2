package com.test.pageObjects;

import com.test.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GitHubRepoPage extends Base {
    public static String repoName = null;
    @FindBy(xpath = "//input[@id='your-repos-filter']")
    public WebElement txt_SearchRepoName;
    @FindBy(xpath = "//*[contains(@class, 'wb-break-all')]")
    public List<WebElement> lst_Repos;
    @FindBy(xpath = "//a[contains(@href ,'stargazers')][contains(@class, 'social-count')]")
    public WebElement lbl_StarCount;
    @FindBy(xpath = "//*[contains(@class, 'wb-break-all')]")
    public WebElement lbl_DynamicRepo;

    public GitHubRepoPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        // Below initializes the page element so that you can work directly on the element
        PageFactory.initElements(driver, this);
    }

    public void getFirstRepoThenNavigateToRepo() {
        try {
            int repoSize = lst_Repos.size();
            if (repoSize > 0) {
                repoName = lst_Repos.get(0).getText();
                txt_SearchRepoName.click();
                txt_SearchRepoName.sendKeys(repoName);
                getDynamicElementforRepo().click();

            }
        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());
        }
    }

    public WebElement getDynamicElementforRepo() {
        return lbl_DynamicRepo.findElement(By.xpath("//*[contains(@href, '" + repoName + "')]"));
    }

    public String getStarsFromUI() {
        return lbl_StarCount.getText();
    }
}
