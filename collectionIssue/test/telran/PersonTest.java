package telran;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PersonTest extends TestCase {


    @Test
    public void testGetAddresses() {
        List<Person> persons = new ArrayList<>(Arrays.asList(new Person("Mary Poppins", new Address("Baker Street",
                        33)), new Person("Charlie Chaplin", new Address("Mon Martre", 2)),
                new Person("Arnold Schwarznegger", new Address("Orange County", 8))));
        List<Address> addresses = Person.getAddresses(persons);
        List<Address> expected = new ArrayList<>(Arrays.asList(new Address("Baker Street",
                33), new Address("Mon Martre", 2), new Address("Orange County", 8)));
        Assert.assertEquals(expected, addresses);
    }
}