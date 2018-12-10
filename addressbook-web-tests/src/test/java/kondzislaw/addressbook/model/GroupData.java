package kondzislaw.addressbook.model;

import java.util.Objects;

public class GroupData {

  private final String id;
  private final String name;
  private final String header;
  private final String footer;

  public GroupData(String Name, String Header, String Footer) {
    this.id = null;
    name = Name;
    header = Header;
    footer = Footer;
  }

  public GroupData(String id, String Name, String Header, String Footer) {
    this.id = id;
    name = Name;
    header = Header;
    footer = Footer;
  }

  public String getId() {
    return id;
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
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return Objects.equals(id, groupData.id) &&
            Objects.equals(name, groupData.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
  }

}
