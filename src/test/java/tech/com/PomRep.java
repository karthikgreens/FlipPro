package tech.com;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomRep extends Base {

	public PomRep() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@class='_2IX_2- VJZDxU']")
	private WebElement logIn;

	@FindBy(xpath = "//input[@class='_2IX_2- _3mctLh VJZDxU']")
	private WebElement Pass;

	@FindBy(xpath = "//input[@class='_3704LK']")
	private WebElement search;

	@FindBy(xpath = "//button[@class='L0Z3Pu']")
	private WebElement srchbtn;

	@FindBy(xpath = "(//span[text()='Login'])[2]")
	private WebElement loginBtn;

	public WebElement getLogIn() {
		return logIn;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getSrchbtn() {
		return srchbtn;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getPass() {
		return Pass;
	}

}
