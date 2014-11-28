package org.anaolabs.java8.defenders;

/**
 * Created with IntelliJ IDEA.
 * User: sylvain
 * Date: 8/1/13
 * Time: 9:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class Account {
    String identification;
    String nickNameHolder;
    String firstNameHolder;
    String lastNameHolder;

    public Account(String identification, String nickNameHolder) {
        this.identification = identification;
        this.nickNameHolder = nickNameHolder;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getFirstNameHolder() {
        return firstNameHolder;
    }

    public void setFirstNameHolder(String firstNameHolder) {
        this.firstNameHolder = firstNameHolder;
    }

    public String getLastNameHolder() {
        return lastNameHolder;
    }

    public void setLastNameHolder(String lastNameHolder) {
        this.lastNameHolder = lastNameHolder;
    }

    public String getNickNameHolder() {
        return nickNameHolder;
    }

    public void setNickNameHolder(String nickNameHolder) {
        this.nickNameHolder = nickNameHolder;
    }

}
