package kondzislaw.addressbook.tests;

import kondzislaw.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {


    app.getNavigationHelper().gotoGroupPage("groups");
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().createGroup(new GroupData("test1",null,null));
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before + 1);
    app.getSessionHelper().logOut();
  }

}
