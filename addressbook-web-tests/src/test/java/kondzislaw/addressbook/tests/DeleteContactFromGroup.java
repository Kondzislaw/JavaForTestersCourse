package kondzislaw.addressbook.tests;

import kondzislaw.addressbook.model.ContactData;
import kondzislaw.addressbook.model.GroupData;
import kondzislaw.addressbook.model.Groups;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteContactFromGroup extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
//    if (app.Contact().all().size() == 0) {
//      app.Contact().create(new ContactData().withFirstName("Konrad").withLastName("Tester")
//              .withAddress("adres").withHome_phone("333222444").withEmail("sample@email"), true);
//      app.goTo().HomePage();
//    }

    if (app.db().groups().size() == 0) {
      app.goTo().GroupPage("groups");
      app.group().create(new GroupData().withName("Test1"));
    }

    List<GroupData> list = app.db().groups().stream().collect(Collectors.toList());
    boolean condition=false;

    for(GroupData g : list){
      if(g.getContacts().size()>0){
        condition=true;
      }
    }

    if(condition==false){
      app.contact().create(new ContactData().withFirstName("Konrad").withLastName("Test").inGroup(list.get(0)),true);
    }
  }

  @Test
  public void testContactRemoveFromGroup (){

    app.goTo().HomePage();
    Groups groups = app.db().groups();
    removeContactFromGroup(groups.size());
  }

  public void removeContactFromGroup(int x){

    Groups groups = app.db().groups();
    GroupData selectedGroup = groups.stream().collect(Collectors.toList()).get(x - 1);

    if (selectedGroup.getContacts().size() > 0) {
      app.contact().selectGroupRemove(selectedGroup.getName());
      Integer id = app.contact().selectContactAndReturnID(0);
      ContactData contact = app.db().getContact(id);
      app.contact().removeFromGroup();
      app.goTo().HomePage();
      Set<GroupData> after = contact.getGroups();
      after.remove(selectedGroup);
      MatcherAssert.assertThat(app.db().getContact(id).getGroups(),
              equalTo(contact.getGroups().without(selectedGroup)));
    } else {
      x--;
      removeContactFromGroup(x);
    }
  }

}
