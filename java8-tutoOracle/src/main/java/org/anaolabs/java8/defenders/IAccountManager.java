package org.anaolabs.java8.defenders;

/**
 * Created with IntelliJ IDEA.
 * User: sylvain
 * Date: 8/1/13
 * Time: 9:20 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IAccountManager {

    /*
     * This is a "defender" method for compatibility with legacy implementations
     */
    default public void createAccount(Account account) {
        System.out.print("Creating new account for "+account.getNickNameHolder());
    }
}
