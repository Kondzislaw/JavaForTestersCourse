package kondzislaw.addressbook.tests;

import kondzislaw.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage("groups");
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().editGroup();
    app.getGroupHelper().fillGroupForm(new GroupData("Test1UPDATED", "TestUPUP2", "Test3UPDATED"));
    app.getGroupHelper().updateGroup();
    app.getGroupHelper().returnToGroupPage("groups");
    app.getSessionHelper().logOut();

  }

}
