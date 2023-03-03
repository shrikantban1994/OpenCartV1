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

	public void SelectSortByOption(String value) {
		Select se = new Select(SortByOption);
		se.selectByValue(value);
	}

	public boolean VerifySearchItems() {
		List<String> ItemList = new ArrayList<String>();
		try {
			for (WebElement element : AllSearchItem) {
				ItemList.add(element.getText());
			}
			List<String> SortedList = new ArrayList<String>(ItemList);
			Collections.sort(SortedList);
			if (SortedList.equals(ItemList)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}

	}

}
