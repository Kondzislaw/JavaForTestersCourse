package kondzislaw.addressbook.tests;

import kondzislaw.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactModification extends TestBase{

  @Test (enabled = true)
  public void contactModification() throws Exception {

    if (! app.getContactsHelper().isThereAContact()){
      app.getContactsHelper().createContact(new ContactData("Konrad", "Tester", "Test Street\nTest City\n01-111 Test", "555444333", "konrad@test.com", "[none]"), true);
    }

    app.goTo().gotoHomePage();

    List<ContactData> before = app.getContactsHelper().getContactList();

    //app.getContactsHelper().selectOneContact(before.size() - 1);
    app.getContactsHelper().editContact(before.size() - 1);
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(),"Konrad", "Tester_CHANGED", null, null, null, null);
    app.getContactsHelper().fillContactForm(contact, false);
    app.getContactsHelper().updateContact();
    app.goTo().gotoHomePage();

    List<ContactData> after = app.getContactsHelper().getContactList();

    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() -1);
    before.add(contact);

    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);

    Assert.assertEquals(before,after);


  }

}



