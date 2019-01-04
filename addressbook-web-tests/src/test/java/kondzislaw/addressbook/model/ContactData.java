package kondzislaw.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;
import java.util.Objects;


@XStreamAlias("contact")
public class ContactData {
  @XStreamOmitField
  private int id = Integer.MAX_VALUE;
  @Expose
  private String firstName;
  @Expose
  private String lastName;
  @Expose
  private String address;
  @Expose
  private String home_phone;
  @Expose
  private String first_email;
  @Expose
  private String group;
  @Expose
  private String mobile_phone;
  @Expose
  private String work_phone;
  @Expose
  private String allPhones;
  @Expose
  private String allEmails;
  @Expose
  private String second_email;
  @Expose
  private String third_email;
  @Expose
  private String all_details;
  private File photo;



  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  public ContactData withAll_details(String all_details) {
    this.all_details = all_details;
    return this;
  }



  public ContactData withEmail2(String second_email) {
    this.second_email = second_email;
    return this;
  }

  public ContactData withEmail3(String third_email) {
    this.third_email = third_email;
    return this;
  }

  public ContactData withEmail(String email) {
    this.first_email = email;
    return this;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }


  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withMobile_phone(String mobile_phone) {
    this.mobile_phone = mobile_phone;
    return this;
  }

  public ContactData withWork_phone(String work_phone) {
    this.work_phone = work_phone;
    return this;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withHome_phone(String home_phone) {
    this.home_phone = home_phone;
    return this;
  }



  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getFirst_email() {
    return first_email;
  }

  public String getAddress() {
    return address;
  }

  public String getHome_phone() {
    return home_phone;
  }

  public String getGroup() {
    return group;
  }

  public int getId() {
    return id;
  }

  public String getWork_phone() {
    return work_phone;
  }

  public String getMobile_phone() {
    return mobile_phone;
  }

  public File getPhoto() {
    return photo;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", address='" + address + '\'' +
            ", home_phone='" + home_phone + '\'' +
            ", first_email='" + first_email + '\'' +
            ", group='" + group + '\'' +
            ", mobile_phone='" + mobile_phone + '\'' +
            ", work_phone='" + work_phone + '\'' +
            ", allPhones='" + allPhones + '\'' +
            ", allEmails='" + allEmails + '\'' +
            ", second_email='" + second_email + '\'' +
            ", third_email='" + third_email + '\'' +
            ", all_details='" + all_details + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstName, that.firstName) &&
            Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName);
  }

  public String getAllPhones() {
    return allPhones;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public String getSecond_email() {
    return second_email;
  }

  public String getThird_email() {
    return third_email;
  }

  public String getAll_details() {
    return all_details;
  }

}
