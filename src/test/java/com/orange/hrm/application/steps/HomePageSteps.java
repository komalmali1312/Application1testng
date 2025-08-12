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
		
	}
	public void verifysidepanel() {
		waitForElementToBeVisible(sidepanel);
		
	}
	public void verifypresenceofmenus()

	{
		waitForElementToBeVisible(menus);
		
	}
	public void verifySearchMenuOption(String Option) {
		waitForElementToBeVisible(Sidebarclosebutton);
		clickElement(Sidebarclosebutton);
		clickElement(Sidebarclosebutton);
		waitForElementToBeVisible(Searchoption);
	    waitForElementToBeVisible(Searchtextbox);
		
		
		//Enter text in searchbox and press enter
		enterText(Searchtextbox, Option);
		
		//Searchtextbox.sendKeys("\n");
		String searchResultText = searchresult.getText();
		
		Assert.assertTrue(searchResultText.contains(Option), "Search result does not contain expected option: " + Option);
		
	}
	
}
