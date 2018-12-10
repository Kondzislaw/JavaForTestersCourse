package kondzislaw.addressbook.model;

import java.util.Objects;

public class GroupData {

  private int id;
  private final String name;
  private final String header;
  private final String footer;

  public GroupData(String Name, String Header, String Footer) {
    this.id = 0;
    name = Name;
    header = Header;
    footer = Footer;
  }



  public GroupData(int id, String Name, String Header, String Footer) {
    this.id = id;
    name = Name;
    header = Header;
    footer = Footer;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return id == groupData.id &&
            Objects.equals(name, groupData.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

}
