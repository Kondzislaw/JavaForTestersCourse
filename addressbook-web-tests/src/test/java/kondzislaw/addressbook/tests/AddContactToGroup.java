package kondzislaw.addressbook.tests;

import kondzislaw.addressbook.model.ContactData;
import kondzislaw.addressbook.model.Contacts;
import kondzislaw.addressbook.model.GroupData;
import kondzislaw.addressbook.model.Groups;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactToGroup extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    Groups groups = app.db().groups();
    if (app.Contact().all().size() == 0) {
      app.Contact().create(new ContactData().withFirstName("Konrad").withLastName("Tester")
              .withAddress("adres").withHome_phone("333222444").withEmail("sample@email"), true);
      app.goTo().HomePage();
    }

    if (app.db().groups().size() == 0) {
      app.goTo().GroupPage("groups");
      app.group().create(new GroupData().withName("Test1"));
    }
  }

  @Test(enabled = true)
  public void addContactToGroup() throws Exception {

    Contacts before = app.db().contacts();
    app.goTo().HomePage();
    app.contact().selectOneContact(before.size() - 1);
    app.contact().addToGroup();
    app.goTo().HomePage();
    Contacts after = app.db().contacts();

     Assert.assertEquals(before,after);

  }

}
