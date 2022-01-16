package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
	public static void main(String[] args) {
		// 크롬 드라이버의 경로를 괄호 안에 넣어야 함
		// 지금 클래스는 드라이버 파일을 가지고 있기 때문에 작성할 필요가 없음
		WebDriver driver = new ChromeDriver();

		// Naver 열기
		driver.get("https://www.naver.com/");

		// 증권 버튼을 눌러보기
		WebElement financeBtn = driver.findElement(
				By.cssSelector("#NM_FAVORITE > div.group_nav > ul.list_nav.NM_FAVORITE_LIST > li:nth-child(3) > a"));
		financeBtn.click();

		// 삼성전자 검색하기
		WebElement searchInput = driver.findElement(By.cssSelector("#stock_items"));
		searchInput.sendKeys("삼성전자");

		// 엔터 누르기
		searchInput.sendKeys(Keys.ENTER);
	}

}
