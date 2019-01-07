package kondzislaw.addressbook.tests;

import kondzislaw.addressbook.model.ContactData;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDetailsTest extends TestBase {

  @Test
  public void testDetailsPage() {

    app.goTo().HomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    ContactData contactInfoFromDetailsPage = app.contact().infoFromDetailsPage(contact);

    assertThat(mergeAll(contactInfoFromEditForm), equalTo(cleaned(contactInfoFromDetailsPage.getAll_details())));

  }

  private String mergeAll(ContactData contact) {
    return Arrays.asList(contact.getFirstName(),contact.getLastName(), contact.getAddress(),"H:",contact.getHome_phone(),"M:",contact.getMobile_phone(),
            "W:",contact.getWork_phone(),contact.getFirst_email(),contact.getSecond_email(),contact.getThird_email())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactDetailsTest::cleaned2)
            .collect(Collectors.joining(""));
  }


  public static String cleaned (String allDetails) {
    return allDetails.replaceAll("\\s", "\n").replaceAll("\\s+","");
  }

  public static String cleaned2(String phone) {
    return phone.replaceAll("\\s+","");
  }

}

