import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void createPerson() {
        String input = "Petya Ivanov";
        Person p = Person.createPerson(input);
        Assert.assertNotNull(p);
        assertEquals("first name", "Petya", p.getFirstName());
        assertEquals("last name", "Ivanov", p.getLastName());
    }
}