package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice {

	// KTX 자동 예매 프로그램
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		// 레츠코레일 열기
		driver.get("https://www.letskorail.com/");

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
		driver.manage().window().maximize();

		// 출발역
		WebElement searchDpt = driver.findElement(By.cssSelector("#txtGoStart"));
		searchDpt.clear();
		searchDpt.sendKeys("익산");

		// 도착역
		WebElement searchArr = driver.findElement(By.cssSelector("#txtGoEnd"));
		searchArr.clear();
		searchArr.sendKeys("용산");

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		// 출발일 설정
		driver.findElement(
				By.cssSelector("#res_cont_tab01 > form > div > fieldset > ul:nth-child(3) > li:nth-child(1) > a > img"))
				.click();
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainPage)) {
				driver.switchTo().window(handle);
				driver.findElement(By.cssSelector(
						"body > div > div.cont > table > tbody > tr:nth-child(2) > td:nth-child(1) > div > div > table > tbody > tr:nth-child(4) > td:nth-child(3) > a"))
						.click();
				driver.switchTo().window(mainPage);
			}
		}

		// 열차 목록 조희
		driver.findElement(By.cssSelector("#res_cont_tab01 > form > div > fieldset > p > a > img")).click();

		// 좌석 선택
		driver.findElement(By.cssSelector("#tableResult > tbody > tr:nth-child(1) > td:nth-child(6) > a:nth-child(3)"))
				.click();
		driver.switchTo().frame("embeded-modal-seatmap");
		driver.findElement(By.cssSelector("body > div > form > div > div.ck_seat > div.tra_num > p > a:nth-child(4)"))
				.click(); // 호차 선택
		driver.findElement(By.cssSelector("#seat_box_id > div > table > tbody > tr:nth-child(4) > td:nth-child(1)")) // 좌석
																														// 선택
				.click();
		driver.findElement(By.cssSelector("#Confirm > a")).click();
		driver.switchTo().window(mainPage);

		// 미등록고객예매
		driver.findElement(By.cssSelector(
				"#contents > div.content > div.cont_info > div.cont_login > div.box_rig > ul > li:nth-child(1) > a"))
				.click();

		// 비회원 발권 안내문
		driver.switchTo().frame("embeded-modal-nomem");
		driver.findElement(By.cssSelector("body > div > div.cont > p.btn_c > a.btn_blue_ang")).click();
		driver.switchTo().window(mainPage);

		// 예약정보 기입
		WebElement inputName = driver.findElement(By.name("txtCustNm"));
		inputName.sendKeys("홍길동");

		WebElement inputNo1 = driver.findElement(By.name("txtCpNo2"));
		inputNo1.sendKeys("1234");

		WebElement inputNo2 = driver.findElement(By.name("txtCpNo3"));
		inputNo2.sendKeys("5678");

		WebElement email1 = driver.findElement(By.name("txtEmail_1"));
		email1.sendKeys("hong");

		WebElement email2 = driver.findElement(By.name("txtEmail_2"));
		email2.sendKeys("naver.com");

		WebElement pwd1 = driver.findElement(By.name("txtCustPw"));
		pwd1.sendKeys("12345");

		WebElement pwd2 = driver.findElement(By.name("txtReCustPw"));
		pwd2.sendKeys("12345");

		driver.findElement(By.cssSelector("#radio1")).click();
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainPage)) {
				driver.switchTo().window(handle);
				driver.findElement(By.cssSelector("#hidToday")).click();
				driver.switchTo().window(mainPage);
			}
		}
		driver.findElement(
				By.cssSelector("#contents > div.content > form > div > div > div:nth-child(3) > input[type=checkbox]"))
				.click();

		// 신청하기 버튼
		driver.findElement(By.cssSelector("#contents > div.content > form > div > p:nth-child(7) > a")).click();

		// 내용 확인
		driver.findElement(By.cssSelector("#korail-alert > div.modal-body > p:nth-child(7) > input[type=checkbox]"))
				.click();
		driver.findElement(By.cssSelector("#okBtn")).click();
		driver.findElement(By.cssSelector("#btn_next")).click();

	}

}
