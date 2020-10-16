package telran.data;

public abstract class Building {
    private String address;
    private String type;

    public Building(String address) {
        this.address = address;
    }

    void setType(String type){
        this.type = type;
    }

    public static class Cafe extends Building{
        public Cafe(String address) {
            super(address);
            setType("Cafe");
        }
    }

    public static class House extends Building{
        public House(String address) {
            super(address);
            setType("House");
        }
    }

    public static class Shop extends Building{
        public Shop(String address) {
            super(address);
            setType("Shop");
        }
    }

    public String getAddress() {
        return address;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Building: " + type +
                "address: " + address;
    }
}
