package telran.data;

public class Hospital {
    private String name;
    private String street;
    private int houseNumber;

    public Hospital(String name, String street, int houseNumber) {
        this.name = name;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    public interface AddressContainer {
        String getStreet();

        int getHouseNumber();
    }

    public AddressContainer getAddressContainer() {
        class HospitalAddressContainer implements AddressContainer {
            String street = Hospital.this.street;
            int houseNumber = Hospital.this.houseNumber;

            @Override
            public String getStreet() {
                return street;
            }

            @Override
            public int getHouseNumber() {
                return houseNumber;
            }
        }
        return new HospitalAddressContainer();
    }
}
