package org.anaolabs.java8.defenders;

/**
 * Created with IntelliJ IDEA.
 * User: sylvain
 * Date: 8/1/13
 * Time: 9:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class LegacyAccountManager implements IAccountManager{

    /**
     * Despite of fact this legacy impl DOES NOT implement all interface methods
     * it compiles as well due to {default} modifier before unimplemented methods
     * ==> "defender" methods
     */
}
