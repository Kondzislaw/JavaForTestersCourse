package kondzislaw.addressbook.tests;

import kondzislaw.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage("groups");
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("Test1", null, null));
    app.getGroupHelper().submitGroupCreation("submit");
    app.getGroupHelper().returnToGroupPage("groups");
    app.getSessionHelper().logOut();
  }

}
