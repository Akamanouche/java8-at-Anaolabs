package org.anaolabs.java8.lambdas;


import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created with IntelliJ IDEA.
 * User: sylvain
 * Date: 7/30/13
 * Time: 7:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestLambdas {

    @Test
    public void testForEach() {
        List<Person> persons = asList(new Person("Joe", 50), new Person("Jim", 60), new Person("John", 30));

        /**
         * Ici, on met en evidence le fait que les Lambdas s'appuient sur des interfaces de type SAM
         * "ActionOnPerson" est une interface SAM
         * Du coup, il n'y a aucune ambiguite apres avec les 2 lambdas expressions qui s'appuient sur elle
         */
        ActionOnPerson shoutFirstName = (p) -> System.out.println("my name is " + p.getFirstName());

        ActionOnPerson shoutJob = (p) -> System.out.println("my age is " + p.getAge());

//        persons.forEach(System.out::println);

        /**
         * Le forEach prend en parametre mes lambdas
         *
         * PUISSANT !!
         */
        persons.forEach(shoutFirstName::act);

        persons.forEach(shoutJob::act);

    }
}
