package seleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		// 레츠코레일 열기
		driver.get("https://www.letskorail.com/");

		// 팝업 종료
		System.out.println(driver.getWindowHandles());

		// main 창
		String mainPage = driver.getWindowHandle();

		// 팝업 창은 닫기
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainPage)) {
				driver.switchTo().window(handle).close();
			}
		}
		
		// main 창으로 핸들러 바꾸기
		driver.switchTo().window(mainPage);

	}

}
