package kondzislaw.addressbook.appmanager;

import kondzislaw.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactsHelper extends BaseHelper {

  public ContactsHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
  }

  public void fillContactForm(ContactData contactData) {

    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("address"), contactData.getAddress());
    click(By.name("theform"));
    type(By.name("home"), contactData.getHome_phone());
    type(By.name("email"), contactData.getEmail());

  }

  public void goToNewContact() {
    click(By.linkText("add new"));
  }
}
