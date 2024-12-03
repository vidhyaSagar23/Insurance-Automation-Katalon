package common

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class InsuranceDetails {
	@Keyword
	def clickUsingProgressBar() {
		WebUI.click(findTestObject('Object Repository/Page_Life Insurance Calculator Term and Who_226915/a_Reset Results'))
		
		WebUI.click(findTestObject('Object Repository/Page_Life Insurance Calculator Term and Who_226915/div__lic-range-hitfield'))
		
		WebUI.click(findTestObject('Object Repository/Page_Life Insurance Calculator Term and Who_226915/div_At what age would you like to retire_li_501042'))
		
		WebUI.click(findTestObject('Object Repository/Page_Life Insurance Calculator Term and Who_226915/div__lic-range-hitfield_1'))
		
		WebUI.click(findTestObject('Object Repository/Page_Life Insurance Calculator Term and Who_226915/div__lic-range-hitfield_1_2'))
		
		WebUI.click(findTestObject('Object Repository/Page_Life Insurance Calculator Term and Who_226915/a_Calculate Results'))
	}
}
