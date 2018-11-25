package kondzislaw.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDelete extends TestBase{


  @Test
  public void contactDelete() throws Exception {

    //app.getContactsHelper().goHome();
    app.getContactsHelper().selectContact();
    app.getContactsHelper().deleteContact();
    app.getContactsHelper().closeAlert();

  }

}
