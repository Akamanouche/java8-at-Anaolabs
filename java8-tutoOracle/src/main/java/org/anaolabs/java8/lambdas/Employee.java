package org.anaolabs.java8.lambdas;

/**
 * Created with IntelliJ IDEA.
 * User: sylvain
 * Date: 8/1/13
 * Time: 11:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class Employee {

    Person person;
    String job;
    String matricule;

    public Employee(Person person) {
        this.person = person;
        this.job = "undetermined";
    }

    public Employee(Person person, String job) {
        this.person = person;
        this.job = job;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    
    public int getAge() {
    	return person.getAge();
		
	}
}
