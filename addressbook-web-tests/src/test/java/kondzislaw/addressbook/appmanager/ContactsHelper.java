package kondzislaw.addressbook.appmanager;

import kondzislaw.addressbook.model.ContactData;
import kondzislaw.addressbook.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class ContactsHelper extends BaseHelper {

  public ContactsHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {

    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHome_phone());
    type(By.name("email"), contactData.getFirst_email());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void goToNewContact() {
    click(By.linkText("add new"));
  }

  public void selectAllContacts() {
    click(By.id("MassCB"));
  }

  public void selectOneContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void closeAlert() {
    wd.switchTo().alert().accept();
  }

  public void deleteContact() {
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select all'])[1]/following::input[2]"));
  }

  public void deleteAllContacts() {
    selectAllContacts();
    deleteContact();
    closeAlert();
    contactCache = null;
  }


  public void editContactById (int id) {

    WebElement table = wd.findElement(By.xpath("//*[@id=\"maintable\"]"));

    WebElement row = table.findElement(By.xpath("//tr/td/*[@id='"+id+"']"));

    row.findElement(By.xpath("//td[8]/a/img")).click();

  }

  public void updateContact() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }

  public void create(ContactData contact, boolean b) {
    goToNewContact();
    fillContactForm(contact, b);
    submitContactCreation();
    contactCache = null;
  }

  public void modify(ContactData contact) {
    editContactById(contact.getId());
    fillContactForm(contact, false);
    updateContact();
    contactCache = null;

  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;


  public Contacts all() {
      if (contactCache != null) {
        return new Contacts (contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      String firstName = element.findElement(By.cssSelector("td:nth-of-type(3)")).getText();
      String lastName = element.findElement(By.cssSelector("td:nth-of-type(2)")).getText();
      String allPhones = element.findElement(By.cssSelector("td:nth-of-type(6)")).getText();
      String allEmails = element.findElement(By.cssSelector("td:nth-of-type(5)")).getText();

      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));

      ContactData contact = new ContactData().withId(id).withFirstName(firstName).withLastName(lastName).withAllPhones(allPhones).withAllEmails(allEmails);
      contactCache.add(contact);
    }
    return new Contacts (contactCache);
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String first_email = wd.findElement(By.name("email")).getAttribute("value");
    String second_email = wd.findElement(By.name("email2")).getAttribute("value");
    String third_email = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();

    return new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname).withHome_phone(home).withMobile_phone(mobile).withWork_phone(work)
            .withEmail(first_email).withEmail2(second_email).withEmail3(third_email);
  }

  private void initContactModificationById(int id) {
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']",id))).click();
  }

}
