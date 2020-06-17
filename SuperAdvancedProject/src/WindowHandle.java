import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/preethasoundararajan/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// maximize the window
		driver.manage().window().maximize();
		
		//go to url
		driver.get("http://testleaf.herokuapp.com/pages/Window.html");
		Thread.sleep(3000);
		
		//open home page
		
		String Homepage = driver.getWindowHandle();
		System.out.println("Homepage :" + Homepage);
		WebElement home = driver.findElement(By.id("home"));
		home.click();
		
		//get the id of all windows
		
		Set<String> allwindows = driver.getWindowHandles();
		System.out.println(allwindows);
		
		for (String sec : allwindows) {
			if (!sec.equals(Homepage)) {
				
			driver.switchTo().window(sec);
			System.out.println(sec);
			Thread.sleep(3000);
			driver.close();
			
			}
		}
		
		//Find the number of opened windows
		driver.switchTo().window(Homepage);
		WebElement Button2 = driver.findElement(By.xpath("//button[contains(text(),'Open Multiple Windows')]"));
		Button2.click();
		
		Set <String> numOpenWin = driver.getWindowHandles();
		int size = numOpenWin.size();
		System.out.println("Number of opened windows" + size);
		
		for (String string : numOpenWin) {
			if (!string.equals(Homepage)) {
				driver.switchTo().window(string);
				Thread.sleep(3000);
				driver.close();
				
			}
			
		}
		
		//wait for few sec
		driver.switchTo().window(Homepage);
		
		WebElement color = driver.findElement(By.id("color"));
		color.click();
		
		Thread.sleep(5000);
		Set<String> num = driver.getWindowHandles();
		System.out.println(num);
		Thread.sleep(2000);
		
		driver.quit();
		
		
	}

}
