package com.example.directory.models;

public class UserProfileModel {

    private int id;

    private String name;

    private String fatherName;

    private int imageResource;

    private String dateOfBirth;

    private String nativeCity;

    private String city;

    private String homeAddressLine1;

    private String homeAddressLine2;

    private String homeAddressLine3;

    private String homeAddressCity;

    private String homeAddressState;

    private String homeAddressPincode;

    private String occupation;

    private String officeAddressLine1;

    private String officeAddressLine2;

    private String officeAddressLine3;

    private String officeAddressCity;

    private String officeAddressState;

    private String officeAddressPincode;

    private String contactNumber;

    private String contactNumber2;

    private String email;

    public UserProfileModel(int id, String name, String fatherName, int imageResource,
                            String dateOfBirth, String nativeCity, String city) {
        this.id = id;
        this.name = name;
        this.fatherName = fatherName;
        this.imageResource = imageResource;
        this.dateOfBirth = dateOfBirth;
        this.nativeCity = nativeCity;
        this.city = city;
    }

    public void setHomeAddressLine1(String homeAddressLine1) {
        this.homeAddressLine1 = homeAddressLine1;
    }

    public void setHomeAddressLine2(String homeAddressLine2) {
        this.homeAddressLine2 = homeAddressLine2;
    }

    public void setHomeAddressLine3(String homeAddressLine3) {
        this.homeAddressLine3 = homeAddressLine3;
    }

    public void setHomeAddressCity(String homeAddressCity) {
        this.homeAddressCity = homeAddressCity;
    }

    public void setHomeAddressState(String homeAddressState) {
        this.homeAddressState = homeAddressState;
    }

    public void setHomeAddressPincode(String homeAddressPincode) {
        this.homeAddressPincode = homeAddressPincode;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setOfficeAddressLine1(String officeAddressLine1) {
        this.officeAddressLine1 = officeAddressLine1;
    }

    public void setOfficeAddressLine2(String officeAddressLine2) {
        this.officeAddressLine2 = officeAddressLine2;
    }

    public void setOfficeAddressLine3(String officeAddressLine3) {
        this.officeAddressLine3 = officeAddressLine3;
    }

    public void setOfficeAddressCity(String officeAddressCity) {
        this.officeAddressCity = officeAddressCity;
    }

    public void setOfficeAddressState(String officeAddressState) {
        this.officeAddressState = officeAddressState;
    }

    public void setOfficeAddressPincode(String officeAddressPincode) {
        this.officeAddressPincode = officeAddressPincode;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setContactNumber2(String contactNumber2) {
        this.contactNumber2 = contactNumber2;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getNativeCity() {
        return nativeCity;
    }

    public String getCity() {
        return city;
    }

    public String getHomeAddressLine1() {
        return homeAddressLine1;
    }

    public String getHomeAddressLine2() {
        return homeAddressLine2;
    }

    public String getHomeAddressLine3() {
        return homeAddressLine3;
    }

    public String getHomeAddressCity() {
        return homeAddressCity;
    }

    public String getHomeAddressState() {
        return homeAddressState;
    }

    public String getHomeAddressPincode() {
        return homeAddressPincode;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getOfficeAddressLine1() {
        return officeAddressLine1;
    }

    public String getOfficeAddressLine2() {
        return officeAddressLine2;
    }

    public String getOfficeAddressLine3() {
        return officeAddressLine3;
    }

    public String getOfficeAddressCity() {
        return officeAddressCity;
    }

    public String getOfficeAddressState() {
        return officeAddressState;
    }

    public String getOfficeAddressPincode() {
        return officeAddressPincode;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getContactNumber2() {
        return contactNumber2;
    }

    public String getEmail() {
        return email;
    }
}

