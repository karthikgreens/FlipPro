package tech.com;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FlipKartPro extends Base {

	@BeforeClass
	public void startBrowser() throws IOException {
		browserLaunch("chrome");
		urlLaunch();
		impWait(10);
	}

	@Test
	public void Project() throws InterruptedException, IOException, AWTException {
		PomRep rp = new PomRep();
		String loginData = new ExcelData().getLoginCrendentials();
		rp.getLogIn().sendKeys(loginData.split("-")[0]);
		rp.getPass().sendKeys(loginData.split("-")[1]);
		rp.getLoginBtn().click();
		WebDriverWait xWait = new WebDriverWait(driver, 10);
		xWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='_3704LK']")));
		rp.getSearch().sendKeys("iphone");
		xWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='L0Z3Pu']")));
		rp.getSrchbtn().click();
		Thread.sleep(5000);
		// Search Phone and Click
		searchPhoneAndClick("APPLE iPhone 13 Pro Max (Alpine Green, 512 GB)");
		// Add to cart
		addToCart();
		// Address Filling
		dataFilling();
		Thread.sleep(5000);
		takePic("Order Done ");
	}

	private void dataFilling() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Place Order']")).click();
		driver.findElement(By.name("name")).sendKeys("Karthik");
		driver.findElement(By.name("phone")).sendKeys("7240572255");
		driver.findElement(By.name("pincode")).sendKeys("600044");
		driver.findElement(By.name("addressLine2")).sendKeys("Chennai");
		driver.findElement(By.name("addressLine1")).sendKeys("No.1, New Street, New Area");
		driver.findElement(By.xpath("(//div[@class='_1XFPmK'])[2]")).click();
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _1JDhFS _3AWRsL']")).click();
	}

	private void addToCart() throws InterruptedException {
		Set<String> se = driver.getWindowHandles();
		List<String> li = new ArrayList<>();
		li.addAll(se);
		driver.switchTo().window(li.get(1));
		WebElement pin = driver.findElement(By.xpath("//input[@id='pincodeInputId']"));
		Actions a = new Actions(driver);
		a.doubleClick().perform();
		Thread.sleep(2000);
		pin.sendKeys("600044");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='_2P_LDn']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();

	}

	private void searchPhoneAndClick(String searchPhone) throws InterruptedException {
		List<String> productNameList = new ArrayList<String>();
		List<WebElement> pagiNation = driver.findElements(By.xpath("//a[contains(@class,'ge-49M')]"));
		for (int i = 0; i < pagiNation.size(); i++) {
			pagiNation.get(i).click();
			Thread.sleep(1000);
			List<WebElement> allProducts = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
			for (WebElement we : allProducts) {
				productNameList.add(we.getText());
			}
			for (String prod : productNameList) {
				if (prod.contains(searchPhone)) {
					WebElement findElement = driver.findElement(By.xpath("//div[text()='" + searchPhone + "']"));
					findElement.click();
					return;
				}
			}
		}
	}

	@AfterClass
	private void close() {
		driver.quit();
	}
}
