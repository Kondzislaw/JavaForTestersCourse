package kondzislaw.addressbook.tests;

import kondzislaw.addressbook.model.ContactData;
import kondzislaw.addressbook.model.Contacts;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactModification extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().HomePage();
    if (app.Contact().all().size() == 0){
      app.Contact().create(new ContactData().withFirstName("Konrad").withLastName("Tester"), true);
    }

  }


  @Test (enabled = false)
  public void contactModification() throws Exception {

    Contacts before = app.Contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("Konrad").withLastName("Tester_CHANGED");
    app.Contact().modify(contact);
    app.goTo().HomePage();
    Contacts after = app.Contact().all();

    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() -1);
    before.add(contact);


    Assert.assertEquals(before,after);


  }



}



