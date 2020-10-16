package telran.data;

public class Office {
    private String company;
    private Address address;

    public class Address{
        private String street;
        private int houseNumber;

        public Address(String street, int houseNumber) {
            this.street = street;
            this.houseNumber = houseNumber;
        }

        @Override
        public String toString() {
            return  street + houseNumber;
        }
    }

    @Override
    public String toString() {
        return "Office of " +
                company +
                ", address=" + address;
    }
}
