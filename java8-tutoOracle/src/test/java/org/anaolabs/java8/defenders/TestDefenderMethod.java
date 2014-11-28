package org.anaolabs.java8.defenders;


import org.junit.Test;

/**
 * Ce test met en relief la "defender method" de la classe {@link IAccountManager}
 * 
 * Created with IntelliJ IDEA.
 * User: sylvain
 * Date: 7/30/13
 * Time: 7:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestDefenderMethod {

    @Test
    public void testDefender() {
        IAccountManager manager = new LegacyAccountManager();
        Account joe = new Account("123","PhillyJoe");
        manager.createAccount(joe);

    }
}
