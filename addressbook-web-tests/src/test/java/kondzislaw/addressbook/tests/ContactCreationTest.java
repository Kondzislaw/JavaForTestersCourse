package kondzislaw.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import kondzislaw.addressbook.model.ContactData;
import kondzislaw.addressbook.model.Contacts;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

//  @DataProvider
//  public Iterator<Object[]> validContactsFromCsv() throws IOException {
//    List<Object[]> list = new ArrayList<Object[]>();
//    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
//    String line = reader.readLine();
//    while (line != null) {
//      String[] split = line.split(";");
//      list.add(new Object[]{new ContactData().withFirstName(split[0]).withLastName(split[1]).withAddress(split[2])
//      .withHome_phone(split[3]).withGroup(split[4])});
//      line = reader.readLine();
//
//    }
//    return list.iterator();
//  }

  @DataProvider
  public Iterator<Object[]> validContactsFromXml() throws IOException {
    //List<Object[]> list = new ArrayList<Object[]>();
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))) {
      String xml = "";
      String line = reader.readLine();
      while (line != null) {
        xml += line;
        line = reader.readLine();
      }
      XStream xstream = new XStream();
      xstream.processAnnotations(ContactData.class);
      List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
      return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }

  @DataProvider
  public Iterator<Object[]> validContactsFromJson() throws IOException {
    //List<Object[]> list = new ArrayList<Object[]>();
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {
      }.getType());
      return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();

    }
  }


  //@Test(dataProvider = "validContactsFromCsv")
  //@Test(dataProvider = "validContactsFromJson")
  @Test(dataProvider = "validContactsFromXml")
  public void testContactCreation(ContactData contact) throws Exception {

    Contacts before = app.Contact().all();
    // File photo = new File("src/test/resources/stru.png");
    //ContactData contact = new ContactData().withFirstName("Konrad").withLastName("Tester").withPhoto(photo).withGroup("[none]");
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
