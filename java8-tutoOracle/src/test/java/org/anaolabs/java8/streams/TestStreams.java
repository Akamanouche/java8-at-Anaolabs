package org.anaolabs.java8.streams;


import org.anaolabs.java8.lambdas.ActionOnEmployee;
import org.anaolabs.java8.lambdas.ActionOnPerson;
import org.anaolabs.java8.lambdas.Employee;
import org.anaolabs.java8.lambdas.Person;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * Created with IntelliJ IDEA.
 * User: sylvain
 * Date: 7/30/13
 * Time: 7:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestStreams {

    @Test
    public void testFilter_onStream() {
        List<Person> persons = asList(new Person("Joe", 50), new Person("Jim", 60), new Person("John", 15));

        /** Mon Stream filtred
         * Remarque :
         * le filtering, lui, ne s'appuie pas sur une lambda
         */
        Stream<Person> streamSeniors = persons.stream().filter(p -> p.getAge() > 18);

        // Ma lambda juste pour afficher le resultat (n'intervient pas du tout dans la phase de filtering)
        ActionOnPerson displayNameAndAge = (p) -> System.out.println("name/age: " + p.getFirstName()+"/"+p.getAge());

        // afficher le resultat
        streamSeniors.forEach(displayNameAndAge::doIt);
    }


    @Test
    public void testFilterAndMap1() {
        List<Person> persons = asList(new Person("Joe", 50), new Person("Jim", 60), new Person("John", 15));

        // Filtering + Mapping en un Stream de Employee(s)
        Stream<Employee> streamSeniors = persons.stream()
                .filter(p -> p.getAge() > 18)
                .map(p -> new Employee(p));
        
        // Si je fait ici un ;count() sur mon Stream, je ne pourrai plus le consommer plus loin dans le .forEach() !
        // System.out.println("Size of my Stream: "+streamSeniors.count());
        
        

        // Ma lambda juste pour afficher le resultat
        ActionOnEmployee displayNameAndAge = (e) -> System.out.println("employee name/job: " + e.getPerson().getFirstName()+"/"+e.getAge());

        // afficher le resultat
        streamSeniors.forEach(displayNameAndAge::doIt);
        
        // "streamSeniors" étant ici un Stream, je NE peux PLUS le reconsommer
        //streamSeniors.forEach(displayNameAndAge::act);
        
    }
    
    @Test
    public void testFilterAndMap2() {
        List<Person> persons = asList(new Person("Joe", 50), new Person("Jim", 60), new Person("John", 15));

        // Filtering + Mapping en une Liste de Employee(s)
        List<Employee> listSeniors = persons.stream()
                .filter(p -> p.getAge() > 18)
                .map(p -> new Employee(p))
                .collect(Collectors.toList());		// <== ici, on dégage une List à partir du Stream

        System.out.println("Size of my List: "+listSeniors.size());
        
        
        // Ma lambda juste pour afficher le resultat
        ActionOnEmployee displayNameAndAge = (e) -> System.out.println("employee name/job: " + e.getPerson().getFirstName()+"/"+e.getAge());

        // afficher le resultat
        listSeniors.forEach(displayNameAndAge::doIt);
        
        // "listSeniors" étant ici une List (et non plus un Stream), je peux le reconsommer
        listSeniors.forEach(displayNameAndAge::doIt);
        
    }
    
    @Test
    public void testFilterAndMap3() {
        List<Person> persons = asList(new Person("Joe", 50), new Person("Jim", 60), new Person("John", 15));

        // Filtering + Mapping en une liste de Integer(s) = age
        Stream<Integer> streamSeniorAges = persons.stream()
                .filter(p -> p.getAge() > 18)
                .map(p -> p.getAge());

        // afficher le resultat
        streamSeniorAges.forEach((e) -> System.out.println("age: " + e));
        // ou encore :
        //streamSeniorAges.forEach(System.out::println);
    }



//    @Test
//    public void testLambdaFilterAndMapStream() {
//        List<Person> persons = asList(new Person("Joe", 50), new Person("Jim", 60), new Person("John", 15));
//
//        // Ma lambda de filtering
//        PersonFilter filter = (p) -> (p.getAge() > 18 ? p : null);
//
//        // 1) Filtering
//        Stream<Employee> streamSeniors = persons.stream()
//                .filter(filter)
//                .map(p -> new Employee(p));
//
//        // Ma lambda
//        ActionOnEmployee displayNameAndAge = (e) -> System.out.println("employee name/job: " + e.getPerson().getFirstName()+"/"+e.getJob());
//
//        // Resultat
//        streamSeniors.forEach(displayNameAndAge::act);
//    }

}
