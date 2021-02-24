package selenium1;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;





public class Chrome {

	public static void main(String[] args) {

		// SET UP ENVIRONMENT
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\resources\\chromedriver.exe");

		// OPENING THE  BROWSER
		ChromeDriver driver = new ChromeDriver();

		//OPEN NAGWA WEBSITE 
		driver.navigate().to("https://www.nagwa.com");

		// SELECT ENGLISH LANGUAGE 
		WebElement lan =driver.findElement(By.xpath("/html/body/div/div/main/div[2]/ul/li[1]/a"));
		lan.click();

		// START SEARCHING PROCESS 
		WebElement search =driver.findElement(By.className("search"));
		search.click();

		// SELECT RANDOM WORD TO SEARCH WITH 
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
		WebElement searchicon =driver.findElement(By.id("btn_global_search"));
		searchicon.click();
		WebElement searchiconres = driver.findElement(By.className("results"));

		// CLICK ON 2 ND LESSON
		WebElement results = searchiconres.findElements(By.tagName("a")).get(1);
		results.click();

		// CLICK ON PREVIEW BUTTON 
		WebElement questions = driver.findElement(By.className("question-preview"));
		questions.click();


		// THE QUESTIONS NUMBER
		WebElement element = driver.findElement(By.className("instances"));
		int numberOfChilds = Integer.parseInt(element.getAttribute("childElementCount"));
		System.out.println("The Questions Number"+numberOfChilds);
	}}




