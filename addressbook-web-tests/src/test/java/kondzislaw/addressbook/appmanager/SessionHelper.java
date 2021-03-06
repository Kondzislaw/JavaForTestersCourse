package kondzislaw.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends BaseHelper {

  public SessionHelper(WebDriver wd) {
    super(wd);
  }

  public void login(String UserName, String password) {

    type(By.name("user"), UserName);
    type(By.name("pass"), password);
    click(By.xpath("//input[@value='Login']"));

  }

  public void logOut() {
    click(By.linkText("Logout"));
   }

}
