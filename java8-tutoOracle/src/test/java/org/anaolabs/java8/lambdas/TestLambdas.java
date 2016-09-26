package org.anaolabs.java8.lambdas;


import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

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
    public void testLambdasBasedOnSAM() {
        List<Person> persons = asList(new Person("Joe", 50), new Person("Jim", 60), new Person("John", 30));

        /**
         * Ici, on met en evidence le fait que les Lambdas s'appuient sur des interfaces de type SAM
         * Rappel : SAM = "Single Abstract Method" (= interfaces ne définissant qu’une seule méthode)
         * 
         * Ici "ActionOnPerson" est bien une interface SAM (étend "Action" qui est une SAM)
         * Du coup, il n'y a aucune ambiguite apres avec les 2 lambdas expressions qui s'appuient sur elle.
         * Les 2 lambdas portent 2 actions différentes sur un même objet (Person), définies de "façon anonymous".
         * On pourrait définir ainsi (n) actions distinctes !
         */
        // 1ère action : afficher le firstName
        ActionOnPerson shoutFirstName = (p) -> System.out.println("my name is " + p.getFirstName());
        
        // 2ème action : afficher l'âge
        ActionOnPerson shoutAge = (p) -> System.out.println("my age is " + p.getAge());

        /**
         * La signature du forEach() est :
         * 			forEach(Consumer<? super T> action)
         * 
         * Le forEach peut prendre en parametre mes lambdas car les 2 s'appuient
         * sur mon interface "Action" qui est une SAM.
         *
         * ==> PUISSANT !!
         */
        persons.forEach(shoutFirstName::doIt);

        persons.forEach(shoutAge::doIt);

    }
    
    
    @Test
    public void testLambdification() {
    	// Notre list de Person(s)
        List<Person> persons = asList(new Person("Joe", 50), new Person("Jim", 60), new Person("John", 30));
        
        /**
         * ## 1er constat
         * Le .sort() avec une LAMBDA fonctionne tel quel.
         * Or aucun des 3 objets de la stack : List->Collection->Iterable n'est une SAM...
         * Donc où est la siouxerie ?...
         */
        persons.sort((p1,p2) -> p1.age - p2.age);
        
        /**
         * idem ci-dessus pour la méthode .forEach() 
         */
        persons.forEach((p) -> System.out.println("my name is " + p.getFirstName()));

        
        /**
         * Alors, cette siouxerie ?!!
         * 
         * OK : ni List, ni Collection, ni Iterable ne sont des SAM...
         * 
         * A regarder de plus prêt, on constate que les signatures des 2 méthodes :
         *       - default void sort(Comparator<? super E> c)
         *       - default void forEach(Consumer<? super T> action)
         *       
         * ... ont en paramètre des interfaces (Comparator et Consumer) qui sont annotées avec :
         *       @FunctionalInterface
         *       
         * ==> C'est ça qui fait que .sort() et .forEach() puissent accepter des expressions Lambdas
         */
        
    }
}
