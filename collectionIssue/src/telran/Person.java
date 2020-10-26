package telran;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {
    private String name;
    private Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }


    //Есть два класса: Address с полями улица и номер дома и Person с полями имя и Address. Нужно написать
    // функцию:List<Address> getAddresses(List<Person> persons) то есть по списку persons возвращать список их адресов
    public static List<Address> getAddresses(List<Person> persons) {
        List<Address> addresses = new ArrayList<>();
        for (Person person : persons) {
            addresses.add(person.getAddress());
        }
        return addresses;
    }
}
