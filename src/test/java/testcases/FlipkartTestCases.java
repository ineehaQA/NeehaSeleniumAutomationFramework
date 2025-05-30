package testcases;

import Base.BaseTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.Set;

public class FlipkartTestCases extends BaseTest {
	
	@Test(priority = 1)
    public void searchItem() {
		
        test = extent.createTest("Search Item Test");
        
        WebElement search =	driver.findElement(By.name("q"));
    	
    	search.sendKeys("Samsung s21 fe 5g");
    	
    	test.log(Status.INFO, "Entered search term");

    	search.submit();
    	
    	test.log(Status.PASS, "Search executed successfully");
	}
	
	@Test(priority = 2)
    public void sortByPrice() throws InterruptedException {

        test = extent.createTest("Sort by Price Test");
        
        test.log(Status.INFO, "Attempting to sort items by price");
        
        driver.findElement(By.xpath("//div[contains(text(),'Price -- Low to High')] ")).click();
    	
    	System.out.println("Prices sorted successfully");
    			
    	WebElement body = driver.findElement(By.tagName("body"));

        body.sendKeys(Keys.PAGE_DOWN);
        
        test.log(Status.PASS, "Items sorted by price successfully");
        
        Thread.sleep(1000);          
	}
	
	@Test(priority = 3)
    public void sortByRating() throws InterruptedException {
		
        test = extent.createTest("Sort by Ratings Test");

        test.log(Status.INFO, "Attempting to sort items by rating");
        
        WebElement ratings = driver.findElement(By.xpath("//div[@title='4★ & above']//div[@class='XqNaEv']"));
        
        Actions actions = new Actions(driver);
       
        actions.moveToElement(ratings).perform();
        
        Thread.sleep(3000);
        
        ratings.click();

        Thread.sleep(3000);
        
        String text = driver.findElement(By.xpath("//span[@class='BUOuZu']")).getText();
        
        System.out.println("No of items : " +text);
        
        Thread.sleep(1000);
        
        test.log(Status.PASS, "Items sorted by rating successfully");
        
	}
	
	@Test(priority = 4)
    public void switchToNewWindow() throws InterruptedException {
		
        test = extent.createTest("Switch Window Test");

        test.log(Status.INFO, "Clicking to open new window and Manage Multiple Windows");
        
        String pw = driver.getWindowHandle();
        
    	driver.findElement(By.className("KzDlHZ")).click();
    	
    	Thread.sleep(1000); 
    	
    	Set<String> windows = driver.getWindowHandles();
    	
    	Thread.sleep(1000);
    	
    	for (String win : windows) {
    		
    		if(!win.equals(pw)) {
    			
    			driver.switchTo().window(win);
    			
    			 test.log(Status.PASS, "Switched to new browser window");
    			
    			break;
    		}
    		
    		String title= driver.getTitle();
    		
    		System.out.println(title);
    	}
    	
    	Thread.sleep(2000);  	
	}
	
	@Test(priority = 5)
    public void checkItemStockStatus() {
		
        test = extent.createTest("Item Stock Status Test");

        test.log(Status.INFO, "Navigating to product page for stock check");
        
        WebElement bodyy = driver.findElement(By.tagName("body"));
        
    	bodyy.sendKeys(Keys.PAGE_DOWN);
    	
    	String statusofsoldoutitem = driver.findElement(By.xpath("//div[@class='IMj1Kv v6sqKe']")).getText();
    	
    	if(statusofsoldoutitem.contains(statusofsoldoutitem)) {
    		
    		System.out.print("Notify Message is : " +statusofsoldoutitem);
    	}
    	
    	else {
    		WebElement additem = driver.findElement(By.xpath("//button[normalize-space()='Add to cart']"));
    		
    		additem.click();
    		
    	    System.out.println("Item Added to Cart Successfully");
    	    
    	}
	}
}
