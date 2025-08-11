package com.orange.hrm.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.orange.hrm.application.elements.HomePageElements;

public class HomePageSteps extends HomePageElements {
	// Method to initialize the page elements
	
	public HomePageSteps(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	public void verifybrandLogo() {
		waitForElementToBeVisible(Homepagebrandlogo);
		log("INFO", "Home page brand logo is displayed");
	}
	public void verifysidepanel() {
		waitForElementToBeVisible(sidepanel);
		log("INFO", "Side panel is displayed");
	}
	public void verifypresenceofmenus()

	{
		waitForElementToBeVisible(menus);
		log("INFO", "Menus are displayed in the side panel");
	}
	public void verifySearchMenuOption(String Option) {
		waitForElementToBeVisible(Sidebarclosebutton);
		clickElement(Sidebarclosebutton);
		clickElement(Sidebarclosebutton);
		waitForElementToBeVisible(Searchoption);
	    waitForElementToBeVisible(Searchtextbox);
		
		log("INFO", "Search option is displayed in the side panel");
		//Enter text in searchbox and press enter
		enterText(Searchtextbox, Option);
		log("INFO", "Entered text in search box: " + Option);
		//Searchtextbox.sendKeys("\n");
		String searchResultText = searchresult.getText();
		log("INFO", "Search result text: " + searchResultText);
		Assert.assertTrue(searchResultText.contains(Option), "Search result does not contain expected option: " + Option);
		
	}
	
}
