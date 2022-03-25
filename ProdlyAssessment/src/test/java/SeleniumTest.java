import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Imported WebDriverManager from MVN Repository
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm");
		
		driver.manage().window().maximize();
		
		//Imported JFairy from MVN Repository, it produces test data and gives a different name everytime we run
		
		Fairy fairy = Fairy.create();

		Person person = fairy.person();
		
		driver.findElement(By.name("firstname")).sendKeys(person.getFirstName());
		
		driver.findElement(By.name("lastname")).sendKeys(person.getLastName());
		
		//Selecting the Radio button
		
		WebElement radio = driver.findElement(By.xpath("//input[@value='Male']"));
		
		radio.click();
		
		//Selecting the Years of Experience radio 
		
		WebElement years = driver.findElement(By.xpath("//input[@value='7']"));
		
		years.click();
		
		driver.findElement(By.xpath("//tr[5]/td[2]/input")).sendKeys("25/03/2022");
		
		//Selecting Profession
		
		WebElement checkbox = driver.findElement(By.xpath("//input[@value='Manual Tester']"));
		
		checkbox.click();
		
		WebElement checkbox1 = driver.findElement(By.xpath("//input[@value='Automation Tester']"));
		
		checkbox1.click();
		
		//Selecting Flavors of Selenium
		
		WebElement option1 = driver.findElement(By.xpath("//input[@value='RC']"));
		
		option1.click();
		
		WebElement option2 = driver.findElement(By.xpath("//input[@value='Selenium IDE']"));
		
		option2.click();
		
		WebElement option3 = driver.findElement(By.xpath("//input[@value='Selenium Webdriver']"));
		
		option3.click();
		
		//Selecting Continent
		
		Select dropContinent = new Select(driver.findElement(By.xpath("//select[@name='continents']")));
		
		dropContinent.selectByVisibleText("North America");
		
		//Submitting the button
		
		driver.findElement(By.xpath("//button[contains(text(),'Button')]")).click();
		
		Alert al = driver.switchTo().alert();
		
		al.accept();
				
	}

}
