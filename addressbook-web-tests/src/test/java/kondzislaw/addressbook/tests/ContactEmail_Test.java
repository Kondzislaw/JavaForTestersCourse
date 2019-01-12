package kondzislaw.addressbook.tests;

import kondzislaw.addressbook.model.ContactData;
import kondzislaw.addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmail_Test extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    Groups groups = app.db().groups();
    if (app.Contact().all().size() == 0){
      app.Contact().create(new ContactData().withFirstName("Konrad").withLastName("Tester")
              .withAddress("adres").withHome_phone("333222444").withEmail("sample@email")
              .inGroup(groups.iterator().next()), true);
      app.goTo().HomePage();
    }

  }

  @Test
  public void testEmail(){

    app.goTo().HomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));

  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getFirst_email(),contact.getSecond_email(), contact.getThird_email())
            .stream().filter((s) -> !s.equals(""))
            .collect(Collectors.joining("\n"));
  }


}
