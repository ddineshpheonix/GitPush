package automation;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class testing {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Started");
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Linus\\eclipse-workspace\\Dinesh\\Browser\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	//	System.setProperty("webdriver.edge.driver", "C:\\Users\\Linus\\eclipse-workspace\\Dinesh\\Browser\\msedgedriver.exe");
	//	WebDriver driver = new EdgeDriver();
		driver.get("https://www.earneasy24.com/login");
		driver.manage().window().maximize();
	//	String ParentWindow = driver.getWindowHandle();
	//	System.out.println(ParentWindow);
		driver.findElement(By.xpath("//div[contains(@class, 'google-sign-in-container')]")).click();
		Thread.sleep(10000);
		String URL = driver.getCurrentUrl();
		System.out.println(URL);		
		String ParentWindow = driver.getWindowHandle();
		System.out.println(ParentWindow);
		
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows);
		System.out.println(windows.size());
		Iterator<String> itr = windows.iterator();
		String mainWindow = itr.next();
		String popup1 = itr.next();
		
		driver.switchTo().window(popup1);
		String URL1 = driver.getCurrentUrl();
		System.out.println(URL1);
		driver.manage().window().maximize();
		WebElement email = driver.findElement(By.xpath("//input[contains(@aria-label, 'Email or phone')]"));
		
		email.click();
		String emailID ="mariganesanlm@gmail.com";
		email.sendKeys(emailID);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(10000);
		
		driver.quit();

	}

}
