package kondzislaw.addressbook.tests;

import kondzislaw.addressbook.model.ContactData;
import kondzislaw.addressbook.model.GroupData;
import org.hibernate.SessionFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class DeleteContactFromGroup extends TestBase {

  private SessionFactory sessionFactory;

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.Contact().all().size() == 0) {
      app.Contact().create(new ContactData().withFirstName("Konrad").withLastName("Tester")
              .withAddress("adres").withHome_phone("333222444").withEmail("sample@email"), true);
      app.goTo().HomePage();
    }

    if (app.db().groups().size() == 0) {
      app.goTo().GroupPage("groups");
      app.group().create(new GroupData().withName("Test1"));
    }
  }

  @BeforeMethod
  public void ensurePrecondition2(){
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


  @Test(enabled = true)


  public void addContactToGroup() throws Exception {

    System.out.println("UDALO SIE");

//    Contacts before = app.db().contacts();
//    app.goTo().HomePage();
//    app.contact().selectOneContact(before.size() - 1);
////    app.contact().addToGroup();
//    app.goTo().HomePage();
//    Contacts after = app.db().contacts();
//
//    Assert.assertEquals(before, after);

  }
}
