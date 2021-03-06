package kondzislaw.addressbook.appmanager;

import kondzislaw.addressbook.model.GroupData;
import kondzislaw.addressbook.model.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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

  public void selectGroupById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void editGroup() {
    click(By.name("edit"));
  }

  public void updateGroup() {
    click(By.name("update"));
  }

  public void create(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation("submit");
    groupCache = null;
    returnToGroupPage("groups");
  }

 public void modify(GroupData group) {
    selectGroupById(group.getId());
    editGroup();
    fillGroupForm(group);
    updateGroup();
   groupCache = null;
    returnToGroupPage("groups");
  }


  public void delete(GroupData group) {
    selectGroupById(group.getId());
    deleteGroup();
    groupCache = null;
    returnToGroupPage("groups");
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Groups groupCache = null;

  public Groups all() {
    if (groupCache != null) {
      return new Groups (groupCache);
    }
    groupCache = new Groups();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groupCache.add(new GroupData().withId(id).withName(name));
    }
   return new Groups (groupCache);
  }

}
