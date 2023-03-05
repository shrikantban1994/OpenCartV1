package pageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SearchPage extends BasePage {

	public SearchPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//select[@id='input-sort']")
	WebElement SortByOption;

	@FindBy(xpath = "//div[@class='caption']//a")
	List<WebElement> AllSearchItem;
	
	@FindBy(xpath ="(//button[@data-toggle='tooltip']//i[@class='fa fa-exchange'])[1]")
	WebElement ComparebtnforiMac;
	
	@FindBy(xpath ="(//button[@data-toggle='tooltip']//i[@class='fa fa-exchange'])[2]")
	WebElement ComparebtnforMacBook;
	
	@FindBy(xpath="//a[@id='compare-total']")
	WebElement TotalComparelink;
	
	@FindBy(xpath="//img[@title='iMac']")
	WebElement iMacimg;

	public void SelectSortByOption() {
		Select se = new Select(SortByOption);
		se.selectByIndex(1);
	}

	public boolean VerifySearchItems() {
		List<String> ItemList = new ArrayList<String>();
		for (WebElement element : AllSearchItem) {
			ItemList.add(element.getText());
		}
		System.out.println(ItemList);
		List<String> SortedList = new ArrayList<String>();
		for (String Item : ItemList) {
			SortedList.add(Item);
		}
		Collections.sort(SortedList);
		System.out.println(SortedList);
		if (SortedList.equals(ItemList)) {
			return true;
		} else {
			return false;
		}
	}
	public void ClickOnComapareiMacbtn() {
		ComparebtnforiMac.click();
	}
	public void  ClickOnComapareMacBookbtn() {
		ComparebtnforMacBook.click();
	}
	public void ClickOnTotalComparelink() {
		TotalComparelink.click();
	}
	public void ClickOniMacimg() {
		iMacimg.click();
	}

}
