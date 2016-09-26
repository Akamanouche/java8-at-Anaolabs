package org.anaolabs.java8.lambdas;

/**
 * Action est bien une SAM
 * 
 * Preuve : on peut l'annoter avec @FunctionalInterface et ça compile bien
 * 
 * Created with IntelliJ IDEA.
 * User: sylvain
 * Date: 8/1/13
 * Time: 11:46 PM
 * To change this template use File | Settings | File Templates.
 */
//@FunctionalInterface
public interface Action<T> {
	
    void doIt(T t);

//    default void dump(T t) {
//        System.out.println(t);
//    }

}
