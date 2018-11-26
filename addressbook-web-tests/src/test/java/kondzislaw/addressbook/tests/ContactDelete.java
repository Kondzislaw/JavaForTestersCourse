package kondzislaw.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDelete extends TestBase{


  @Test
  public void contactDelete() throws Exception {

    app.getContactsHelper().selectAllContacts();
    app.getContactsHelper().deleteContact();
    app.getContactsHelper().closeAlert();

  }

}
