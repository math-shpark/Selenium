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
		WebElement searchDpt = driver.findElement(By.cssSelector("출발역 cssSelector"));
		searchDpt.clear();
		searchDpt.sendKeys("출발역 이름");

		// 도착역
		WebElement searchArr = driver.findElement(By.cssSelector("도착역 cssSelector"));
		searchArr.clear();
		searchArr.sendKeys("도착역 이름");

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); // 1초 대기 시간 부여

		// 출발일 설정
		driver.findElement(
				By.cssSelector("달력 그림 cssSelector"))
				.click();
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainPage)) {
				driver.switchTo().window(handle); // 새로운 창으로 전환
				driver.findElement(By.cssSelector(
						"출발일 클릭 cssSelector"))
						.click();
				driver.switchTo().window(mainPage); // 원래 창으로 전환
			}
		}

		// 열차 목록 조희
		driver.findElement(By.cssSelector("열차 조회 cssSelector")).click();

		// 좌석 선택
		driver.findElement(By.cssSelector("좌석 선택 버튼 cssSelector"))
				.click();
		driver.switchTo().frame("iframe의 id"); // 좌석 선택 창으로 전환
		driver.findElement(By.cssSelector("호차 선택 버튼 cssSelector"))
				.click(); // 호차 선택
		driver.findElement(By.cssSelector("좌석 선택 버튼 cssSelector")) // 좌석
																														// 선택
				.click();
		driver.findElement(By.cssSelector("확인버튼 cssSelector")).click();
		driver.switchTo().window(mainPage); // 원래 창으로 전환

		// 미등록고객예매
		driver.findElement(By.cssSelector(
				"미등록 고객 버튼 cssSelector"))
				.click();

		// 비회원 발권 안내문
		driver.switchTo().frame("안내문 창 id");
		driver.findElement(By.cssSelector("확인 버튼 cssSelector")).click();
		driver.switchTo().window(mainPage); // 원래 창으로 전환

		// 예약정보 기입
		WebElement inputName = driver.findElement(By.name("이름 input의 name"));
		inputName.sendKeys("홍길동");

		WebElement inputNo1 = driver.findElement(By.name("휴대폰 번호 1 input의 name"));
		inputNo1.sendKeys("1234");

		WebElement inputNo2 = driver.findElement(By.name("휴대폰 번호 2 input의 name"));
		inputNo2.sendKeys("5678");

		WebElement email1 = driver.findElement(By.name("email 1 input의 name"));
		email1.sendKeys("hong");

		WebElement email2 = driver.findElement(By.name("email 2 input의 name"));
		email2.sendKeys("naver.com");

		WebElement pwd1 = driver.findElement(By.name("비밀번호 input의 name"));
		pwd1.sendKeys("12345");

		WebElement pwd2 = driver.findElement(By.name("비밀번호 확인 input의 name"));
		pwd2.sendKeys("12345");

		driver.findElement(By.cssSelector("동의 체크 cssSelector")).click();
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainPage)) {
				driver.switchTo().window(handle); // 새로운 창으로 전환
				driver.findElement(By.cssSelector("오늘 보이지 않기 버튼 cssSelector")).click();
				driver.switchTo().window(mainPage);
			}
		}
		driver.findElement(
				By.cssSelector("개인정보 동의 체크 cssSelector"))
				.click();

		// 신청하기 버튼
		driver.findElement(By.cssSelector("신청하기 버튼 cssSelector")).click();

		// 내용 확인
		driver.findElement(By.cssSelector("내용 확인 버튼 cssSelector"))
				.click();
		driver.findElement(By.cssSelector("확인 버튼 cssSelector")).click();
		driver.findElement(By.cssSelector("다음 버튼 cssSelector")).click();

	}

}
