package de.maryfro.demo.entity;

public class Contact {

    public int id;
    public String name;
    public String lastName;
    public int age;
    static int staticId = 0;

    public Contact(String name, String lastName, int age) {
        this.id = staticId++;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Contact() {
       // this.id = staticId++;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public static void setStaticId(int staticId) {
        Contact.staticId = staticId;
    }

    public static int getStaticId() {
        return staticId;


    }
}
