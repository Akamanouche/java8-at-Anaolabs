package org.anaolabs.java8.lambdas;

/**
 * Created with IntelliJ IDEA.
 * User: sylvain
 * Date: 7/30/13
 * Time: 7:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class Person {
    String firstName;
    String lastName;
    int age;

    public Person(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {

        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
