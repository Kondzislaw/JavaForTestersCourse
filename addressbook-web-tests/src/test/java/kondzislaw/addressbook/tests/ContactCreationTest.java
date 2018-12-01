package kondzislaw.addressbook.tests;

import kondzislaw.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase{


  @Test
  public void testContactCreation() throws Exception {
    //app.getContactsHelper().fillContactForm(new ContactData("Konrad", "Tester", "Test Street\nTest City\n01-111 Test", "555444333", "konrad@test.com", "Test1UPDATED"), true);
    //app.getContactsHelper().submitContactCreation();
    app.getContactsHelper().createContact(new ContactData("Konrad", "Tester", "Test Street\nTest City\n01-111 Test", "555444333", "konrad@test.com", "Test1UPDATED"), true);
    app.getNavigationHelper().gotoHomePage();
    app.getSessionHelper().logOut();
  }


}
