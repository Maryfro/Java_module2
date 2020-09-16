package de.telran.data;

import java.util.Objects;

public class Address {
    private String city, street;
    private int houseNumber;

    public Address(String city, String street, int houseNumber) {
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    String getCity() {
        return city;
    }

    String getStreet() {
        return street;
    }

    int getHouseNumber() {
        return houseNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return houseNumber == address.houseNumber &&
                city.equals(address.city) &&
                street.equals(address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, houseNumber);
    }

    @Override
    public String toString() {
        return "Address: " +
                "city: " + city +
                ", street: " + street +
                ", houseNumber: " + houseNumber;
    }
}
