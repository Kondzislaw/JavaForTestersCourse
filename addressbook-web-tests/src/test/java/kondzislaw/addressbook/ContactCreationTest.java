package kondzislaw.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase{


  @Test
  public void testContactCreation() throws Exception {
    goToNewContact();
    fillContactForm(new ContactData("Konrad", "Tester", "Test Street\nTest City\n01-111 Test", "555444333", "konrad@test.com"));
    submitContactCreation();
    contactLogOut();
  }


}
