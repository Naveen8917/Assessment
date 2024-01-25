package Assessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
	static {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.wipo.int/patinformed/");
		driver.findElement(By.xpath("/html/body/app-root/page-search/div[2]/input")).sendKeys("sel");   //we can enter any name
		driver.findElement(By.className("green")).click();
		driver.findElement(By.xpath("/html/body/app-root/page-search/div[2]/div/table/tbody/tr[1]/td[3]/ul/li[1]")).click();
		boolean Jurisdiction = driver.findElement(By.xpath("/html/body/app-root/page-search/div[2]/family-details/div/div[2]/ul/li[1]/table/tr[1]/td[2]")).isDisplayed();
		if (Jurisdiction==true) 
		{
			String pd = driver.findElement(By.xpath("//html/body/app-root/page-search/div[2]/family-details/div/div[2]/ul/li[1]/table/tr[3]")).getText();
			String fd = driver.findElement(By.xpath("/html/body/app-root/page-search/div[2]/family-details/div/div[2]/ul/li[1]/table/tr[4]")).getText();
			System.out.println(pd);
			System.out.println(fd);
		}
		else
			System.out.println("Given Jurisdiction: WO- WIPO not found");
		driver.quit();
	}
}
