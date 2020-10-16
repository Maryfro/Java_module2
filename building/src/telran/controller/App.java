package telran.controller;

import telran.data.Building;
import telran.data.Cinema;
import telran.data.Hospital;
import telran.data.Office;

public class App {
    public static void main(String[] args) {
        Building building = new Building.Shop("Potsdamer Platz, 2");
        System.out.println(building.getType());
        System.out.println(building.toString());

        Building.Cafe cafe = new Building.Cafe("Alexanderplatz, 5");
        Building building1 = new Cinema("Leopoldplatz, 10");
        Office office = new Office();
        Office.Address address = office.new Address(" Mehringdamm", 33);

        Office office1 = new Office();
        Office.Address address1 = office.new Address(" Mehringdamm", 22){
            @Override
            public String toString() {
                return "office moved";
            }
        };
        System.out.println(address1);

        Hospital clinic = new Hospital("Charite", "Berliner",12 );
        Hospital.AddressContainer addressHospital = clinic.getAddressContainer();
        System.out.println(addressHospital.getHouseNumber());
        System.out.println(addressHospital.getStreet());

    }

}
