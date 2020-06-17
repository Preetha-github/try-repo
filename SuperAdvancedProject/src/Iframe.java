import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframe {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/preethasoundararajan/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// maximize the window
		driver.manage().window().maximize();
		
		//go to url
		driver.get("http://testleaf.herokuapp.com/pages/frame.html");
		Thread.sleep(3000);
		
		driver.switchTo().frame(0);
		WebElement iframe1 = driver.findElement(By.id("Click"));
		iframe1.click();
		String txt = iframe1.getText();
		System.out.println(txt);

		Thread.sleep(3000);
		
		//
		driver.switchTo().defaultContent();
		//I am inside a nested frame 
		
		driver.switchTo().frame(1);
		driver.switchTo().frame("frame2");
		WebElement button2 = driver.findElement(By.id("Click1"));
		button2.click();
		//
		driver.switchTo().defaultContent();
		
		// total iframes
		
		List <WebElement> tag = driver.findElements(By.tagName("iframe"));
		int size = tag.size();
		System.out.println("size : " + size);
		driver.quit();
	}

}
