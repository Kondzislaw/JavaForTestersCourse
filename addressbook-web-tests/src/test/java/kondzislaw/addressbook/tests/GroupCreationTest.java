package kondzislaw.addressbook.tests;

import kondzislaw.addressbook.model.GroupData;
import kondzislaw.addressbook.model.Groups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {


  @DataProvider
  public Iterator<Object[]> validGroups(){
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[]{new GroupData().withName("test1").withHeader("header1").withFooter("footer1")});
    list.add(new Object[]{new GroupData().withName("test2").withHeader("header2").withFooter("footer2")});
    list.add(new Object[]{new GroupData().withName("test3").withHeader("header3").withFooter("footer3")});
    return list.iterator();
  }

  @Test (dataProvider = "validGroups")
  public void testGroupCreation(GroupData group) throws Exception {
    //GroupData group = new GroupData().withName("Test2");
    app.goTo().GroupPage("groups");
    Groups before = app.group().all();
    app.group().create(group);
    Groups after = app.group().all();
    assertThat(app.group().count(), equalTo(before.size() + 1));
    //assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

  @Test (enabled = false)
  public void testBadGroupCreation() throws Exception {

    app.goTo().GroupPage("groups");
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("Test2'''");
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.group().all();
    assertThat(after.size(), equalTo(before.size()));

  }

}
