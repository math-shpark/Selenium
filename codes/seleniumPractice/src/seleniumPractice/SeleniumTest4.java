package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		// srt 열기
		driver.get("https://etk.srail.kr/main.do");

		// 출발역 선택
		Select departure = new Select(driver.findElement(By.name("dptRsStnCd")));
		departure.selectByVisibleText("수서");

		// 도착역 선택
		Select arrival = new Select(driver.findElement(By.name("arvRsStnCd")));
		arrival.selectByValue("0030");

		// 조회 버튼 클릭
		driver.findElement(By.cssSelector("#search-form > fieldset > a > span")).click();

	}

}
