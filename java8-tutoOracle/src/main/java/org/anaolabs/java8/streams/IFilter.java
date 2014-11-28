package org.anaolabs.java8.streams;

/**
 * My basic SAM iface for filtering, which have to be extended by other interfaces
 * used by lambdas
 *
 *
 * Created with IntelliJ IDEA.
 * User: t791491
 * Date: 02/08/13
 * Time: 13:23
 * To change this template use File | Settings | File Templates.
 */
public interface IFilter<T> {

    T filter(T t);
}
