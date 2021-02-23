package DepartmentEmployeeFlatMap;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentServiceTest {
    DepartmentService ds = new DepartmentService();
    Department sales = new Department("sales", "012/ux",
            new ArrayList<>(Arrays.asList(new Employee("John", 45000),
                    new Employee("Sarah", 38000),
                    new Employee("Jim", 80000))));
    Department accounting = new Department("accounting", "0127/ac",
            new ArrayList<>(Arrays.asList(new Employee("Pete", 42500),
                    new Employee("Jess", 39000),
                    new Employee("Glen", 39500))));
    Department management = new Department("management", "0001/mn",
            new ArrayList<>(Arrays.asList(new Employee("Dr.Smith", 155000),
                    new Employee("Dr. Boss", 200000))));


    @Test
    public void test_countEmployees_existingprefix_lowThreshold(){
        assertEquals(6, ds.countEmployees(new ArrayList<>(Arrays.asList(sales, accounting, management)), 35000, "012"));
    }

    @Test
    public void test_countEmployees_NonExistingprefix_middleThreshold(){
        assertEquals(0, ds.countEmployees(new ArrayList<>(Arrays.asList(sales, accounting, management)), 40000, "oo12"));
    }
    @Test
    public void test_countEmployees_existingprefix_middleThreshold(){
        assertEquals(3, ds.countEmployees(new ArrayList<>(Arrays.asList(sales, accounting, management)), 40000, "012"));
    }

    @Test
    public void test_countEmployees_existingprefix_highThreshold(){
        assertEquals(3, ds.countEmployees(new ArrayList<>(Arrays.asList(sales, accounting, management)), 79000, "0"));
    }

    @Test
    public void test_countEmployees_allEmployees(){
        assertEquals(8, ds.countEmployees(new ArrayList<>(Arrays.asList(sales, accounting, management)), 0, ""));
    }

}