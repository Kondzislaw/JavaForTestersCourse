package kondzislaw.addressbook.tests;

import kondzislaw.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactModification extends TestBase{

  @Test
  public void contactModification() throws Exception {

    if (! app.getContactsHelper().isThereAContact()){
      app.getContactsHelper().createContact(new ContactData("Konrad", "Tester", "Test Street\nTest City\n01-111 Test", "555444333", "konrad@test.com", "Test1UPDATED"), true);
    }
    app.getNavigationHelper().gotoHomePage();
    app.getContactsHelper().selectOneContact();
    app.getContactsHelper().editContact();
    app.getContactsHelper().fillContactForm(new ContactData("Konrad", "Tester_CHANGED", "Test Street\nTest City\n01-111 Test", "555444333", "konrad@test.com", null), false);
    app.getContactsHelper().updateContact();

  }

}



