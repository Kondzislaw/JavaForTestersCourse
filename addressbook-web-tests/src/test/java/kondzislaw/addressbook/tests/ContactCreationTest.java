package kondzislaw.addressbook.tests;

import kondzislaw.addressbook.model.ContactData;
import kondzislaw.addressbook.model.Contacts;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {


  @Test(enabled = true)
  public void testContactCreation() throws Exception {

    Contacts before = app.Contact().all();
    File photo = new File("src/test/resources/stru.png");
    ContactData contact = new ContactData().withFirstName("Konrad").withLastName("Tester").withPhoto(photo).withGroup("[none]");
    app.Contact().create((contact), true);
    app.goTo().HomePage();
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.Contact().all();


    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }


}
