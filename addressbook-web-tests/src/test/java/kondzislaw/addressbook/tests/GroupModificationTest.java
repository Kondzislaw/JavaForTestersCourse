package kondzislaw.addressbook.tests;

import kondzislaw.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage("groups");

    if (! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("Test1", null, null));
    }
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().selectGroup(before - 1);
    app.getGroupHelper().editGroup();
    app.getGroupHelper().fillGroupForm(new GroupData("Test1UPDATED", "TestUPUP2", "Test3UPDATED"));
    app.getGroupHelper().updateGroup();
    app.getGroupHelper().returnToGroupPage("groups");
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before);
    app.getSessionHelper().logOut();

  }

}
