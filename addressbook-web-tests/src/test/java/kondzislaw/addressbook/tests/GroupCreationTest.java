package kondzislaw.addressbook.tests;

import kondzislaw.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {
    app.gotoGroupPage("groups");
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("Test1", "Test2", "Test3"));
    app.submitGroupCreation("submit");
    app.returnToGroupPage("groups");
    app.returnToGroupPage("Logout");
  }

}
