package Tests;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import PageObjects.TopChart;

public class IMDbTop250Test {
	
	WebDriver driver;
	private String tableXpath = "//table[@data-caller-name='chart-top250movie']/tbody/tr";
	
	@Before
	
	public void setup() {
		
		driver = new FirefoxDriver();
		
		TopChart onTopChart = new TopChart(driver);
		onTopChart.NavigateVerifyMoviesList();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}
    
	@After
	public void CloseTest(){
		
		driver.close();
		
	}
	
	//This is to check 1st Scenario
	@Test	
	public void TestDefaultMovieList() throws Exception{
		
		TopChart VerifyDefaultList = new TopChart(driver);
		Assert.assertTrue(VerifyDefaultList.TopChartPage(tableXpath));
		
	}
	

	//This is to check 2nd Scenario
	@Test
	public void TestSortingOptions() throws Exception {
		
		TopChart VerifySortList = new TopChart(driver);
		Select selectByValue = new Select(driver.findElement(By.name("sort")));
		List<WebElement> sortOptions = selectByValue.getOptions();
		
		for(WebElement sortOption : sortOptions) {
		
			System.out.println("Sort options is:->" + sortOption.getText());
			selectByValue.selectByVisibleText(sortOption.getText());
			
			Assert.assertTrue(VerifySortList.TopChartPage(tableXpath));
		}
	}
	
	//This is to check 3rd Scenario
	@Test
	public void TestWesternGenre() throws Exception {
		
		TopChart VerifyGenreList = new TopChart(driver);
		
		WebElement GenreLink = driver.findElement(By.linkText("Western"));
		GenreLink.click();
		
		Assert.assertTrue(VerifyGenreList.TopChartPage("//table[@class='results']/tbody/tr"));		
	}
	
		
}

