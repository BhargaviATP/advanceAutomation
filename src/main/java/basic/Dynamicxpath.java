package basic;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Dynamicxpath  {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/table/dynamic-table");
		
		WebElement ele1 = driver.findElement(By.xpath("(//tr[contains(@class,'bg-white border-b')])[1]/td[3]"));
		WebElement ele2 = driver.findElement(By.xpath("(//tr[contains(@class,'bg-white border-b')])[1]/td[4]"));
		System.out.println(" Discount:"+ele1.getText()+"  Price:"+ele2.getText());// Scenario 1: How to select a Dynamic cell value
		System.out.println(" ");
		List<WebElement> elements= driver.findElements(By.xpath("//tr[contains(@class,'bg-white border-b')]"));
		for(WebElement i:elements) {
			System.out.println(i.getText());// Scenario 2: How to select all the data from the coloumns ?
		}
		Thread.sleep(3000);
		driver.quit();
	}
}
