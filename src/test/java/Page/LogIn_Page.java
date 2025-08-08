package Page;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utils.Browser;
import Utils.Failed_Retry;
import Utils.Waits;

public class LogIn_Page extends Browser implements Waits {
	public final String WebTitle = "Swag Labs";

	@Override
	public void ImplicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Override
	public void ExplicitWait(WebElement element, int timeoutSec) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSec));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	@Override
	public void FluenWait(WebElement element, int timeoutSec, int pollingSec) {
		// TODO Auto-generated method stub

	}

	@Test(priority = 1, retryAnalyzer = Failed_Retry.class)
	public void loginpage() {

		ImplicitWait();
		String Title = driver.getTitle();

		AssertJUnit.assertEquals(WebTitle, Title);

		if (WebTitle.equals(Title)) {

			driver.findElement(By.xpath(pagelocaters.getProperty("NAME_FIELD")))
					.sendKeys(websitedetails.getProperty("USER_NAME"));

			driver.findElement(By.xpath(pagelocaters.getProperty("PASSWORD_FIELD")))
					.sendKeys(websitedetails.getProperty("USER_PASSWORD"));

			driver.findElement(By.xpath(pagelocaters.getProperty("LOGIN_BUTTON"))).click();

		}

	}

}
