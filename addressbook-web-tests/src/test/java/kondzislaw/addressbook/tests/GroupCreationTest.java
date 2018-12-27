package kondzislaw.addressbook.tests;

import kondzislaw.addressbook.model.GroupData;
import kondzislaw.addressbook.model.Groups;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {

    app.goTo().GroupPage("groups");
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("Test2");
    app.group().create(group);
    Groups after = app.group().all();
    assertThat(app.group().count(), equalTo(before.size() + 1));
    //assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

  @Test
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
