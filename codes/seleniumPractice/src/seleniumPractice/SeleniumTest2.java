package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

		// 네이버 금융뉴스 열기
		driver.get("https://finance.naver.com/news/");

		// 오늘의 뉴스들
		List<WebElement> news = driver.findElements(By.cssSelector(".main_news > ul > li > a"));
		
		// 오늘의 뉴스 출력
		for (WebElement el : news) {
			System.out.println(el.getText());
		}

	}

}
