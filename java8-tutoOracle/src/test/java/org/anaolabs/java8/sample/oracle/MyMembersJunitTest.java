package org.anaolabs.java8.sample.oracle;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * TUTO de reference :
 * > http://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 *
 *
 * Created with IntelliJ IDEA.
 * User: sylvain
 * Date: 7/30/13
 * Time: 7:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyMembersJunitTest {

    // Ma liste entiere de tous les membres
    List<Member> roster;

    @Before
    public void initData() {
        roster = new ArrayList<>();
        roster.add(
                new Member(
                        "Fred",
                        new GregorianCalendar(1980, 6, 20),
                        Member.Sex.MALE,
                        "fred@example.com"));
        roster.add(
                new Member(
                        "Jane",
                        new GregorianCalendar(1990, 7, 15),
                        Member.Sex.FEMALE, "jane@example.com"));
        roster.add(
                new Member(
                        "George",
                        new GregorianCalendar(1991, 8, 13),
                        Member.Sex.MALE, "george@example.com"));
        roster.add(
                new Member(
                        "Bob",
                        new GregorianCalendar(2000, 9, 12),
                        Member.Sex.MALE, "bob@example.com"));
    }

    ///////////////////////////////////////////////////////////////////////////
    // Approach 5: Specify Search Criteria Code with a Lambda Expression
    ///////////////////////////////////////////////////////////////////////////
    private void printMembers(
            List<Member> roster, CheckMember tester) {
        for (Member member : roster) {
            if (tester.test(member)) {
                member.printMember();
            }
        }
    }

    @Test
    public void approch5_PrintMembers() {

        System.out.println("Approach 5: Specify Search Criteria Code with a Lambda Expression");

//        printMembers(
//            roster,
//            // CE QUI SUIT définit une Lambda Expression qui va s'appuyer sur l'iface SAM "CheckMember"
//            (Member p) -> p.getGender() == Member.Sex.MALE
//                && p.getAge() >= 18
//                && p.getAge() <= 25
//        );

        /*
         * Ca peut aussi s'écrire comme ceci :
         * on definit explicitement une lambda sur l'iface SAM
         */
        CheckMember myLambda = (Member p) -> p.getGender() == Member.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
        printMembers(roster, myLambda);

    }

    ///////////////////////////////////////////////////////////////////////////
    // Approach 6: Use Standard Functional Interfaces with Lambda Expressions
    ///////////////////////////////////////////////////////////////////////////

    /*
     * Cette fois-ci, on passe par un
     */
    private void printMembersWithPredicate(
            List<Member> roster, Predicate<Member> tester) {
        for (Member member : roster) {
            if (tester.test(member)) {
                member.printMember();
            }
        }
    }

    @Test
    public void approch6_PrintMembersWithPredicate() {

        System.out.println("Approach 6: Use Standard Functional Interfaces with Lambda Expressions (with Predicate parameter)");

//        printMembersWithPredicate(
//                roster,
//                p -> p.getGender() == Member.Sex.MALE
//                        && p.getAge() >= 18
//                        && p.getAge() <= 25
//        );

        /*
         * Ca peut aussi s'écrire comme ceci :
         * on definit explicitement une lambda sur le Predicate
         */
        Predicate<Member> myLambda = p -> p.getGender() == Member.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
        printMembersWithPredicate(roster, myLambda);

    }


    ///////////////////////////////////////////////////////////////////////////
    // Approach 7: Use Lamba Expressions Throughout Your Application
    ///////////////////////////////////////////////////////////////////////////

    private void processMembersWithPredicateAndConsumer(
            List<Member> roster,
            Predicate<Member> tester,
            Consumer<Member> block) {
        for (Member member : roster) {
            if (tester.test(member)) {
                block.accept(member);
            }
        }
    }

    @Test
    public void approch7_PrintMembersWithPredicateAndConsumer() {
        System.out.println("Approach 7: Use Lamba Expressions Throughout Your Application (with Predicate and Consumer parameters)");

//        processMembersWithPredicateAndConsumer(
//                roster,
//                p -> p.getGender() == Member.Sex.MALE
//                        && p.getAge() >= 18
//                        && p.getAge() <= 25,
//                p -> p.printMember()
//        );

        /*
         * Ca peut aussi s'écrire comme ceci :
         * on definit explicitement une lambda sur le Predicate et le Consumer
         * Un degre de decouplage en plus / a l'approche precedente (sans Consumer)
         */
        Predicate<Member> myLambdaPredicate = p -> p.getGender() == Member.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
        Consumer<Member> myLambdaConsumer =  p -> System.out.println("Filtered gender: "+p.getName()+" / age: "+p.getAge());
        processMembersWithPredicateAndConsumer(roster,myLambdaPredicate,myLambdaConsumer);
    }


    ///////////////////////////////////////////////////////////////////////////
    // Approach 8, second example (with Predicate,Function,and Consumer parameters)
    ///////////////////////////////////////////////////////////////////////////

    private void processMembersWithFunction(
            List<Member> roster,
            Predicate<Member> tester,
            Function<Member, String> mapper,
            Consumer<String> block) {
        for (Member member : roster) {
            if (tester.test(member)) {
                String data = mapper.apply(member);
                block.accept(data);
            }
        }
    }


    @Test
    public void approch8_PrintMembersWithPredicateAndConsumer() {
        System.out.println("Approach 8, second example (with Predicate, Function, and Consumer parameters)");

//        processMembersWithFunction(
//                roster,
//                p -> p.getGender() == Member.Sex.MALE
//                        && p.getAge() >= 18
//                        && p.getAge() <= 25,
//                p -> p.getEmailAddress(),
//                email -> System.out.println(email)


    }
}
