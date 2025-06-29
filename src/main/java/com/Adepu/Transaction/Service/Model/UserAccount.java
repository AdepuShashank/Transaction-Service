package com.Adepu.Transaction.Service.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int accountId;

    private String userName;
    private long phoneNumber;
    private int balance;

    public UserAccount(int accountId, String userName, int balance, long phoneNumber) {
        this.accountId = accountId;
        this.phoneNumber = phoneNumber;
        this.userName = userName;

        this.balance = balance;
    }

    public UserAccount() {

    }


    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getFirstName() {
        return userName;
    }

    public void setFirstName(String firstName) {
        this.userName = firstName;
    }



    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "accountId=" + accountId +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", firstName='" + userName + '\'' +

                ", balance=" + balance +
                '}';
    }
}
