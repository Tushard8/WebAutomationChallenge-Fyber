package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopChart extends AbstractPage {
	
	public String xpath;
	
	public TopChart(WebDriver driver) {
		
		super(driver);
				
	}
	
	public boolean TopChartPage(String xpath) {
		
	List<WebElement> rows = driver.findElements(By.xpath(xpath));
	
	System.out.println("Number of rows are :->" + rows.size());
	
	return rows.size() > 1 ? true : false;
	
	}

}
