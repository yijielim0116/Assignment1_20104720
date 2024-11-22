package org.example.assignment1_20104720;

import java.util.Objects;

public class TheatreCustomer {
    //Fields
    private String name;
    private String emailAddress;
    private String phoneNumber;

    //List of booking lists
    public DisplayBookingList theatreBookingList = new DisplayBookingList();

    //Constructor
    public TheatreCustomer(String name, String emailAddress, String phoneNumber) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    //Methods
    @Override
    public String toString() {
        return "TheatreCustomer{" +
                "name='" + name + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TheatreCustomer that = (TheatreCustomer) obj;
        return name.equals(that.name) &&
                emailAddress.equals(that.emailAddress) &&
                phoneNumber.equals(that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, emailAddress, phoneNumber);
    }
}
