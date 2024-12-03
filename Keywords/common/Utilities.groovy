package common
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


class Utilities {
	/**
	 * Refresh browser
	 */
	@Keyword
	def refreshBrowser() {
		KeywordUtil.logInfo("Refreshing")
		WebDriver webDriver = DriverFactory.getWebDriver()
		webDriver.navigate().refresh()
		KeywordUtil.markPassed("Refresh successfully")
	}

	/**
	 * Click element
	 * @param to Katalon test object
	 */
	@Keyword
	def clickElement(TestObject to) {
		try {
			WebElement element = WebUiBuiltInKeywords.findWebElement(to);
			KeywordUtil.logInfo("Clicking element")
			element.click()
			KeywordUtil.markPassed("Element has been clicked")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
		}
	}

	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	@Keyword
	def List<WebElement> getHtmlTableRows(TestObject table, String outerTagName) {
		WebElement mailList = WebUiBuiltInKeywords.findWebElement(table)
		List<WebElement> selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}

	@Keyword
	def calculateInsuranceValue(String individualIncome = "0", String retirementAge = "0", String totalDept = "0", String dependentsFunds = "0", String savedOrInvested = "0", String savedForRetirement = "0", String howMuchInsuranceHave = "0", String expectedCostsFuneral = "8300") {
		println(individualIncome)
		WebUI.click(findTestObject('Object Repository/Result Page/a_Reset Results'))
		WebUI.setText(findTestObject('Object Repository/Calculations Page/input__individual income'), individualIncome)
		WebUI.setText(findTestObject('Object Repository/Calculations Page/input_retirement age'), retirementAge)
		WebUI.setText(findTestObject('Object Repository/Calculations Page/input__totalDept'), totalDept)
		WebUI.setText(findTestObject('Object Repository/Calculations Page/input__dependentsFund'), dependentsFunds)
		WebUI.setText(findTestObject('Object Repository/Calculations Page/input__savedOrInvested'), savedOrInvested)
		WebUI.setText(findTestObject('Object Repository/Calculations Page/input__savedForRetirement'), savedForRetirement)
		WebUI.setText(findTestObject('Object Repository/Calculations Page/input__howMuchInsuranceHave'), howMuchInsuranceHave)
		WebUI.setText(findTestObject('Object Repository/Calculations Page/input__expectedCostFuneral'), expectedCostsFuneral)
		WebUI.click(findTestObject('Object Repository/Calculations Page/a_Calculate Results'))
	}

	@Keyword
	def logicCalculationsInsurance(def individualIncome, def retirementAge, def totalDept, def dependentsFunds, def savedOrInvested, def savedForRetirement, def howMuchInsuranceHave, def expectedCostsFuneral, def currentAge) {
		// Current age (this can be adjusted based on the input or user preference)
		//		def currentAge = 35.17 // Approximated from earlier calculation
		// Calculate years until retirement
		def yearsUntilRetirement = retirementAge - currentAge
		// Income replacement calculation
		def incomeReplacement = individualIncome * yearsUntilRetirement
		// Additional costs
		def additionalCosts = totalDept + dependentsFunds + expectedCostsFuneral
		// Savings and insurance available
		def savingsAndInsurance = savedOrInvested + howMuchInsuranceHave
		// Final insurance needed
		def insuranceNeeded = incomeReplacement + additionalCosts - savingsAndInsurance
		println(insuranceNeeded)
	}

	@Keyword
	def verifyResult(TestObject to, String expectedResult) {
		WebUI.verifyElementText(to, expectedResult)
	}
	
	@Keyword
	def dragAndIncreaseValue(TestObject to) {
		
	}
}