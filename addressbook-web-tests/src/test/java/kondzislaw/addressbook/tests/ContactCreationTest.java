package kondzislaw.addressbook.tests;

import kondzislaw.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase{


  @Test
  public void testContactCreation() throws Exception {

    List<ContactData> before = app.getContactsHelper().getContactList();
    ContactData contact = new ContactData("Konrad", "Tester", null, null, null, "[none]");
    app.getContactsHelper().createContact((contact), true);
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactsHelper().getContactList();

    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);

    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);

    Assert.assertEquals(before,after);


    app.getSessionHelper().logOut();
  }


}
