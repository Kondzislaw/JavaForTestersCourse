package kondzislaw.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {
    gotoGroupPage("groups");
    initGroupCreation();
    fillGroupForm(new GroupData("Test1", "Test2", "Test3"));
    submitGroupCreation("submit");
    returnToGroupPage("groups");
    returnToGroupPage("Logout");
  }

}
