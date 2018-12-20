package kondzislaw.addressbook.tests;

import kondzislaw.addressbook.model.ContactData;
import kondzislaw.addressbook.model.Contacts;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactDelete extends TestBase {


  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().HomePage();
    if (app.Contact().all().size() == 0){
      app.Contact().create(new ContactData().withFirstName("Konrad").withLastName("Tester"), true);
    }

  }

  @Test (enabled = true)
  public void contactDelete() throws Exception {

    app.Contact().selectAllContacts();
    app.Contact().deleteContact();
    app.Contact().closeAlert();
    Contacts after = app.Contact().all();
    Assert.assertEquals(after.size(), 0);


  }

}
