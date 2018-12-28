package kondzislaw.addressbook.tests;

import kondzislaw.addressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTest extends TestBase {


  @BeforeMethod
  public void ensurePreconditions(){

    if (app.Contact().all().size() == 0){
      app.Contact().create(new ContactData().withFirstName("Konrad").withLastName("Tester").withAddress("adres").withHome_phone("333222444").withEmail("sample@email").withGroup("[none]"), true);
      app.goTo().HomePage();
    }

  }

  @Test
  public void testContactPhones(){

    app.goTo().HomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getHome_phone(), equalTo(contactInfoFromEditForm.getHome_phone()));
    assertThat(contact.getMobile_phone(), equalTo(contactInfoFromEditForm.getMobile_phone()));
    assertThat(contact.getWork_phone(), equalTo(contactInfoFromEditForm.getWork_phone()));

  }




}
