package entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Nationalized;

import java.time.Instant;

@Entity
@Table(name = "Employees")
public class Employee {
    @Id
    @Column(name = "EmployeeID", nullable = false)
    private Integer id;

    @Size(max = 20)
    @NotNull
    @Nationalized
    @Column(name = "LastName", nullable = false, length = 20)
    private String lastName;

    @Size(max = 10)
    @NotNull
    @Nationalized
    @Column(name = "FirstName", nullable = false, length = 10)
    private String firstName;

    @Size(max = 30)
    @Nationalized
    @Column(name = "Title", length = 30)
    private String title;

    @Size(max = 25)
    @Nationalized
    @Column(name = "TitleOfCourtesy", length = 25)
    private String titleOfCourtesy;

    @Column(name = "BirthDate")
    private Instant birthDate;

    @Column(name = "HireDate")
    private Instant hireDate;

    @Size(max = 60)
    @Nationalized
    @Column(name = "Address", length = 60)
    private String address;

    @Size(max = 15)
    @Nationalized
    @Column(name = "City", length = 15)
    private String city;

    @Size(max = 15)
    @Nationalized
    @Column(name = "Region", length = 15)
    private String region;

    @Size(max = 10)
    @Nationalized
    @Column(name = "PostalCode", length = 10)
    private String postalCode;

    @Size(max = 15)
    @Nationalized
    @Column(name = "Country", length = 15)
    private String country;

    @Size(max = 24)
    @Nationalized
    @Column(name = "HomePhone", length = 24)
    private String homePhone;

    @Size(max = 4)
    @Nationalized
    @Column(name = "Extension", length = 4)
    private String extension;

    @Column(name = "Photo")
    private byte[] photo;

    @Nationalized
    @Lob
    @Column(name = "Notes")
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ReportsTo")
    private Employee reportsTo;

    @Size(max = 255)
    @Nationalized
    @Column(name = "PhotoPath")
    private String photoPath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleOfCourtesy() {
        return titleOfCourtesy;
    }

    public void setTitleOfCourtesy(String titleOfCourtesy) {
        this.titleOfCourtesy = titleOfCourtesy;
    }

    public Instant getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Instant birthDate) {
        this.birthDate = birthDate;
    }

    public Instant getHireDate() {
        return hireDate;
    }

    public void setHireDate(Instant hireDate) {
        this.hireDate = hireDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Employee getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Employee reportsTo) {
        this.reportsTo = reportsTo;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

}