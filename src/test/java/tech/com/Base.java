package tech.com;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;

	public static WebDriver browserLaunch(String l) {
		switch (l) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "fox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		default:
			break;
		}
		return driver;
	}

	public static void impWait(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}

	public static void urlLaunch() throws IOException {
		FileReader reader = new FileReader(
				"D:\\Studies\\ws-new\\ProNewAllNew\\src\\test\\resources\\application.properties");
		Properties p = new Properties();
		p.load(reader);
		driver.get(p.getProperty("url"));
	}

	public static void takePic(String l) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sas = ts.getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		File f = new File("D:\\Studies\\ws-new\\ProNewAllNew\\ScreenShots\\" + l + d.getSeconds() + ".jpeg");
		FileUtils.moveFile(sas, f);
	}

}
