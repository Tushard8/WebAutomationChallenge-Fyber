package PageObjects;

import org.openqa.selenium.WebDriver;

public class AbstractPage {
	
	public String baseUrl = "http://www.imdb.com/chart/top";
		
	protected WebDriver driver;
	
	public AbstractPage (WebDriver driver){
		this.driver = driver;
	}
	
	public WebDriver getDriver(){
		return driver;
	}
	
	public TopChart NavigateVerifyMoviesList(){
	driver.get(baseUrl);
	return new 	TopChart(driver);
 }

}
