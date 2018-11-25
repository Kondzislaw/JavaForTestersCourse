package kondzislaw.addressbook.model;

public class ContactData {
  private final String firstName;
  private final String lastName;
  private final String address;
  private final String home_phone;
  private final String email;

  public ContactData(String firstName, String lastName, String address, String home_phone, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.home_phone = home_phone;
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getAddress() {
    return address;
  }

  public String getHome_phone() {
    return home_phone;
  }

  public String getEmail() {
    return email;
  }
}
