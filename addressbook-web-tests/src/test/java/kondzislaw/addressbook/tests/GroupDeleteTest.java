package kondzislaw.addressbook.tests;

import kondzislaw.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDeleteTest extends TestBase {

  @Test
  public void testGroupDelete() throws Exception {
    app.getNavigationHelper().gotoGroupPage("groups");

    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("Test1", null, null));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().deleteGroup();
    app.getGroupHelper().returnToGroupPage("groups");
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);

    app.getSessionHelper().logOut();

  }

}
