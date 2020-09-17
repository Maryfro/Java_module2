package telran.data;

import java.util.Objects;

public class Cinema {
    private String title;
    private Address address;

    public Cinema(String title) {
        this.title = title;
    }

    public Cinema(String title, Address address) {
        this.title = title;
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cinema cinema = (Cinema) o;
        return title.equals(cinema.title) &&
                address.equals(cinema.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, address);
    }

    @Override
    public String toString() {
        return "Cinema " +
                title + ", address: " + address;
    }

    public static boolean isCinemaInArray(String name, Cinema[] cinemas) {
        for (Cinema c : cinemas) {
            if (c.title.equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
}
