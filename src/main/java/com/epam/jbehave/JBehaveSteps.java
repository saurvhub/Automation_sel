package com.epam.jbehave;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.By;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.open;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * @author Saurabh_Verma Contains all the step definition for google
 */
public class JBehaveSteps extends Steps {
    /**
     * driver path.
     */
    private static final String PATH = "./src/main/resources/chromedriver.exe";
    /**
     * sleep time in milliseconds.
     */
    private static final int SLEEP_TIME = 1000;
    /**
     * timeout in milliseconds.
     */
    private static final int TIMEOUT = 1000;

    /**
     * @throws IOException
     *             if chromedriver not found
     *
     */
    @Given("User is on Google page")
    public void givenUserIsOnGooglepage() throws IOException {
        String path = new File(PATH).getCanonicalPath().toString();
        System.setProperty("webdriver.chrome.driver", path);
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://www.google.com";
        Configuration.timeout = TIMEOUT;
        open(Configuration.baseUrl);
    }

    /**
     * @param searchText
     *            String text to be searched.
     */
    @When("User enters '$searchText' in search field")
    public void whenUserEntersInSearchField(@Named("searchText")
    final String searchText) {
        $(By.id("lst-ib")).sendKeys(searchText);

    }

    /**
     * @throws InterruptedException
     *             when sleep is
     */
    @When("User clicks on search button")
    public void whenUserClicksOnSearchButton() throws InterruptedException {
        $(By.name("btnK")).click();
        Thread.sleep(SLEEP_TIME);
    }

    /**
     * @param link
     *            text contained in link to be clicked.
     * @throws InterruptedException
     *             if sleep is interrupted
     */
    @Then("user clicks '$link' Link")
    public void whenUserClicksLink(@Named("link")
    final String link) throws InterruptedException {
        ElementsCollection elementsCollection = $$(By.className("r"));
        SelenideElement ourLink =
                elementsCollection.find(Condition.hasText(link));
        ourLink.click();
        Thread.sleep(SLEEP_TIME);
    }
}
