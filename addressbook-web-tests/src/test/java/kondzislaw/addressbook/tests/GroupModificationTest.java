package kondzislaw.addressbook.tests;

import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage("groups");
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().editGroup();
    app.getGroupHelper().updateGroup();
    app.getGroupHelper().returnToGroupPage("groups");
    app.getSessionHelper().logOut();

  }

}
