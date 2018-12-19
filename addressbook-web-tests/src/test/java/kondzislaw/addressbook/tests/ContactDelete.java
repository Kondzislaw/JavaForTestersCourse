package kondzislaw.addressbook.tests;

import kondzislaw.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDelete extends TestBase {


  @Test (enabled = true)
  public void contactDelete() throws Exception {


    if (!app.getContactsHelper().isThereAContact()) {
      app.getContactsHelper().createContact(new ContactData("Konrad", "Tester", "Test Street\nTest City\n01-111 Test", "555444333", "konrad@test.com", "Test1UPDATED"), true);
    }
    app.goTo().gotoHomePage();

    app.getContactsHelper().selectAllContacts();
    app.getContactsHelper().deleteContact();
    app.getContactsHelper().closeAlert();
    List<ContactData> after = app.getContactsHelper().getContactList();
    Assert.assertEquals(after.size(), 0);


  }

}
