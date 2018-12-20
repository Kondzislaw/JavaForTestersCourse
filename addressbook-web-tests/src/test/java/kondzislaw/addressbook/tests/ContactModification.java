package kondzislaw.addressbook.tests;

import kondzislaw.addressbook.model.ContactData;
import kondzislaw.addressbook.model.Contacts;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModification extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){

    if (app.Contact().all().size() == 0){
      app.Contact().create(new ContactData().withFirstName("Konrad").withLastName("Tester").withAddress("adres").withHome_phone("333222444").withEmail("sample@email").withGroup("[none]"), true);
      app.goTo().HomePage();
    }

  }


  @Test (enabled = true)
  public void contactModification() throws Exception {

    Contacts before = app.Contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("Konrad").withLastName("Tester_CHANGED");
    app.Contact().modify(contact);
    app.goTo().HomePage();
    Contacts after = app.Contact().all();

    Assert.assertEquals(after.size(), before.size());
    Assert.assertEquals(before,after);
    assertThat(after,equalTo(before));

  }



}



