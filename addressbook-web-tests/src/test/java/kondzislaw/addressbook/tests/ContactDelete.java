package kondzislaw.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDelete extends TestBase{


  @Test
  public void contactDelete() throws Exception {

//    if (! app.getContactsHelper().isThereAContact()){
//      app.getContactsHelper().createContact(new ContactData("Konrad", "Tester", "Test Street\nTest City\n01-111 Test", "555444333", "konrad@test.com", "Test1UPDATED"), true);
//    }

    app.getContactsHelper().selectAllContacts();
    app.getContactsHelper().deleteContact();
    app.getContactsHelper().closeAlert();

  }

}
