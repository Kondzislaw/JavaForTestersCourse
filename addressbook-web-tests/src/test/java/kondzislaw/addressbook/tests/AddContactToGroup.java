package kondzislaw.addressbook.tests;

import kondzislaw.addressbook.model.ContactData;
import kondzislaw.addressbook.model.GroupData;
import kondzislaw.addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactToGroup extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {

    if (app.Contact().all().size() == 0) {
      app.Contact().create(new ContactData().withFirstName("Konrad").withLastName("Tester")
              .withAddress("adres").withHome_phone("333222444").withEmail("sample@email"), true);
      app.goTo().HomePage();
    }
  }

  @Test
  public void testContactAddingToGroup() {
    app.goTo().HomePage();
    Integer id = app.contact().selectContactAndReturnID(0);
    ContactData contact = app.db().getContact(id);
    Groups groups = app.db().groups();

    List<GroupData> available = new ArrayList<>();
    available.addAll(groups);
    available.removeAll(contact.getGroups());

    if(available.size()>0){
      app.contact().selectGroupAdd(available.get(0).getName());
      app.contact().addToGroup();
      assertThat(app.db().getContact(contact.getId()).getGroups(),
              equalTo(contact.getGroups().withAdded(available.get(0))));
    }
    else{
      app.goTo().GroupPage("groups");
      app.group().create(new GroupData().withName("newgroup "+ new Date()));
      testContactAddingToGroup();
    }
  }
}
