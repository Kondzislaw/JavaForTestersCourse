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
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteGroup() {
    click(By.name("delete"));
  }

  public void selectGroup(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void editGroup() {
    click(By.name("edit"));
  }

  public void updateGroup() {
    click(By.name("update"));
  }

  public void createGroup(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation("submit");
    returnToGroupPage("groups");
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }
}
