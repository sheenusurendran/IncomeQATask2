package com.test.pageObjects;

import com.test.apisetup.GitHubDetails;
import com.test.utils.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GitHubRepoPage extends Base {
    public static String repoName = null;

    public GitHubRepoPage(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(@href,'?tab=repositories')]")
    public WebElement lbl_FirstRepoName;

    @FindBy(xpath = "//input[@id='your-repos-filter']")
    public WebElement txt_SearchRepoName;

    @FindBy(xpath = "//*[contains(@class, 'wb-break-all')]")
    public List<WebElement> lst_Repos;

    @FindBy(xpath = "//a[contains(@href ,'stargazers')][contains(@class, 'social-count')]")
    public WebElement lbl_StarCount;


    public void SearchForRepo() {
        WaitUntilElementVisible(txt_SearchRepoName);
        txt_SearchRepoName.click();
        txt_SearchRepoName.sendKeys();
    }

    /*public WebElement getDynamicElementforRepo() {
        List<String> repoStars = GitHubDetails.getGitHubUserDetails();
        String repo =repoStars.get(0);
        return lb_todocount.findElement(By.xpath("//strong[contains(text(),'" + count + "')]"));
    }*/
    public void getFirstRepoThenNavigateToRepo() {
        int repoSize = lst_Repos.size();
        if (repoSize > 0) {
            String repoName = lst_Repos.get(0).getText();
            lst_Repos.get(0).click();
        }
    }

        public String getStarsFromUI() {
            String starsCountUI =lbl_StarCount.getText();
            return starsCountUI;
        }
    }



