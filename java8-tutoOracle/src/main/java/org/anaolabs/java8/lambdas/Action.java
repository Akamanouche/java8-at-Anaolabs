package org.anaolabs.java8.lambdas;

/**
 * Created with IntelliJ IDEA.
 * User: sylvain
 * Date: 8/1/13
 * Time: 11:46 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Action<T> {
    void act(T t);

//    default void dump(T t) {
//        System.out.println(t);
//    }

}
