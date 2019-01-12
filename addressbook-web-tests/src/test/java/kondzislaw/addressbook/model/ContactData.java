package kondzislaw.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")

public class ContactData {

  @XStreamOmitField
  @Id
  private int id = Integer.MAX_VALUE;

  @Expose
  @Column(name = "firstname")
  private String firstName;

  @Expose
  @Column(name = "lastname")
  private String lastName;

  @Expose
  @Column(name = "address")
  @Type(type = "text")
  private String address;

  @Expose
  @Column(name = "home")
  @Type(type = "text")
  private String home_phone;

  @Expose
  @Column(name = "email")
  @Type(type = "text")
  private String first_email;

  @Expose
  @Column(name = "mobile")
  @Type(type = "text")
  private String mobile_phone;

  @Expose
  @Column(name = "work")
  @Type(type = "text")
  private String work_phone;

  @Expose
  @Transient
  private String allPhones;

  @Expose
  @Transient
  private String allEmails;

  @Expose
  @Column(name = "email2")
  @Type(type = "text")
  private String second_email;

  @Expose
  @Column(name = "email3")
  @Type(type = "text")
  private String third_email;

  @Expose
  @Transient
  private String all_details;

  @Column(name = "photo")
  @Type(type = "text")
  private String photo;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "address_in_groups", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
  private Set<GroupData> groups = new HashSet<GroupData>();


  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
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
    return new File(photo);
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

  public Groups getGroups() {
    return new Groups(groups);
  }

  public ContactData inGroup(GroupData group) {
    groups.add(group);
    return this;
  }
}
