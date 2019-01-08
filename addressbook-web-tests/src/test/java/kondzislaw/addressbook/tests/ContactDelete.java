package kondzislaw.addressbook.tests;

import kondzislaw.addressbook.model.ContactData;
import kondzislaw.addressbook.model.Contacts;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactDelete extends TestBase {


  @BeforeMethod
  public void ensurePreconditions(){
if (app.db().contacts().size() == 0){
      app.Contact().create(new ContactData().withFirstName("Konrad").withLastName("Tester").withAddress("adres").withHome_phone("333222444").withEmail("sample@email").withGroup("[none]"), true);
      app.goTo().HomePage();
    }
  }

  @Test (enabled = true)
  public void contactDelete() throws Exception {

    Contacts before = app.db().contacts();
    app.Contact().deleteAllContacts();
    Contacts after = app.db().contactsDeleted();
    Assert.assertNotEquals(after,before);

    }



}
