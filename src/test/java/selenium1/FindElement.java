package selenium1;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;




public class FindElement {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\resources\\chromedriver.exe");

		// Opening the  browser
		ChromeDriver driver = new ChromeDriver();
		//Open nagwa website 
		driver.navigate().to("https://www.nagwa.com");
		//select English language 
		WebElement lan =driver.findElement(By.xpath("/html/body/div/div/main/div[2]/ul/li[1]/a"));
		lan.click();
		// start searching process 

		WebElement search =driver.findElement(By.className("search"));
		search.click();
		//WebElement searchactive = driver.findElement(By.id("txt_search_query"));
		//select random word to search with 
		String[] searchword = {"arabic","english","math","test","art"};
		StringBuilder sb = new StringBuilder(3);
		Random random = new Random();
		for (int i = 0; i < 1; i++) {
			String c = searchword[random.nextInt(searchword.length)];
			sb.append(c);
		}
		String output = sb.toString();
		WebElement sw = driver.findElement(By.id("txt_search_query"));
		sw.sendKeys(output);
		//driver.findElement(By.id("txt_search_query")).sendKeys("course");

		WebElement searchicon =driver.findElement(By.id("btn_global_search"));
		searchicon.click();
		WebElement searchiconres = driver.findElement(By.className("results"));
		//Click on 2 nd lesson
		WebElement results = searchiconres.findElements(By.tagName("a")).get(1);
		results.click();
		//navigate back 
		driver.navigate().back();  
		//print out the search result 
		List<WebElement> allElements = driver.findElements(By.className("results")); 

		for (WebElement element: allElements) {
			System.out.println(element.getText());


		} 
	}}




