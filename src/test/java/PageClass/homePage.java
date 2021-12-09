package PageClass;



import java.io.FileInputStream;
import java.io.IOException;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;

import static org.junit.Assert.*;



public class homePage extends PageObject {
	
		@FindBy(xpath="//i[@class='fa fa-user-o']")
		private WebElementFacade accountIcon;
	
		@FindBy(xpath="//a[@class='btn btn-primary']")
		private WebElementFacade registerButton;
		
		@FindBy(id="input-firstname")
		private WebElementFacade firstName;
		
		@FindBy(id="input-lastname")
		private WebElementFacade lastName;
		
		@FindBy(id="input-email")
		private WebElementFacade email;
		
		@FindBy(id="input-telephone")
		private WebElementFacade telephone;
		
		@FindBy(id="input-address-1")
		private WebElementFacade address1;
		
		@FindBy(id="input-address-2")
		private WebElementFacade address2;
		
		@FindBy(id="input-city")
		private WebElementFacade city;
		
		@FindBy(id="input-postcode")
		private WebElementFacade postalCode;
		
		@FindBy(id="input-country")
		private WebElementFacade country;
		
		@FindBy(xpath="//*[@id=\"input-zone\"]")
		private WebElementFacade state;
		
		@FindBy(id="input-password")
		private WebElementFacade password;
		
		@FindBy(id="input-confirm")
		private WebElementFacade confirmPassword;
		
		@FindBy(xpath="//input[@name='agree']")
		private WebElementFacade privacyPolicy;
		
		@FindBy(xpath="//input[@type='submit']")
		private WebElementFacade btnContinue;
		
		@FindBy(xpath="//*[@id=\"System_nyHsmShk\"]/div[1]")
		private WebElementFacade warningMessage;
		
		@FindBy(xpath="//*[@id=\"PageTitleSystem_B083XYxw\"]/h1")
		private WebElementFacade successMessage;
		
		@FindBy(xpath="//a[@class='btn btn-primary']")
		private WebElementFacade continueButton;
		
		@FindBy(xpath="//a[@class='btn btn-primary']")
		private WebElementFacade btnLogin;
		
		
		
	public void launchApplication() {
		getDriver().get("http://retailm1.upskills.in/");
	}
	
	public void clickOnAccountIcon() {
		accountIcon.click();
	}
	
	public void clickOnRegisterLink() {		
		registerButton.click();		
	}
	
	public void clickOnLoginLink() {
		btnLogin.click();
	}
	
	public void enterMandatoryFields(String data) throws IOException {
		readExcelData(data);
	}
	
	
	public void readExcelData(String fileName) throws IOException {
		FileInputStream fs=new FileInputStream("RegistrationData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);
		firstName.sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
		lastName.sendKeys(sheet.getRow(1).getCell(1).getStringCellValue());
		email.sendKeys(sheet.getRow(1).getCell(2).getStringCellValue());
		
		telephone.sendKeys(sheet.getRow(1).getCell(3).getStringCellValue());
		address1.sendKeys(sheet.getRow(1).getCell(4).getStringCellValue());
		address2.sendKeys(sheet.getRow(1).getCell(5).getStringCellValue());
		city.sendKeys(sheet.getRow(1).getCell(6).getStringCellValue());
		postalCode.sendKeys(sheet.getRow(1).getCell(7).getStringCellValue());
		country.selectByVisibleText(sheet.getRow(1).getCell(8).getStringCellValue());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)", "");
		state.selectByVisibleText(sheet.getRow(1).getCell(9).getStringCellValue());
		password.sendKeys(sheet.getRow(1).getCell(10).getStringCellValue());
		confirmPassword.sendKeys(sheet.getRow(1).getCell(11).getStringCellValue());
		privacyPolicy.click();
		btnContinue.click();		
	}
	
	public void verifySuccessMessage() {
		try {
			if(getDriver().getCurrentUrl().equals("http://retailm1.upskills.in/account/success"))
			{
			assertEquals("Your Account Has Been Created!", successMessage.getText());
			continueButton.click();			
		}
		}
		catch(Exception e)
		{
			assertEquals("Warning: E-Mail Address is already registered!", warningMessage.getText());
		}		
	}
	
	public void enterUserDetails(String Email, String Password) {
		email.sendKeys(Email);
		password.sendKeys(Password);		
	}
	
}
