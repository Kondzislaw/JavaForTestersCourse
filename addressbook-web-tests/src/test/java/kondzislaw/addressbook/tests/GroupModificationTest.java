package kondzislaw.addressbook.tests;

import kondzislaw.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTest extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage("groups");

    if (! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("Test1", null, null));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().editGroup();
    GroupData group = new GroupData(before.get(before.size() - 1).getId(),"Test1UPDATED", "TestUPUP2", "Test3UPDATED");
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().updateGroup();
    app.getGroupHelper().returnToGroupPage("groups");
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());


    before.remove(before.size() -1);
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

    app.getSessionHelper().logOut();

  }

}
