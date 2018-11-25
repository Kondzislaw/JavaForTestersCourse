package kondzislaw.addressbook.appmanager;

import kondzislaw.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends BaseHelper {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToGroupPage(String groups) {
    click(By.linkText(groups));
  }

  public void submitGroupCreation(String submit) {
    click(By.name(submit));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getName());
    type(By.name("group_footer"), groupData.getName());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }
}
