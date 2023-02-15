package com.bank.service.impl;

import com.bank.BankAccount;
import com.bank.BankMenu;
import org.junit.jupiter.api.Test;

import static TestUtil.TestUtil.getBankAccount;
import static org.junit.jupiter.api.Assertions.*;


class BankServiceImplTest {

    @Test
    void withdrawShouldUpdateBankAccountBalance() {
        BankServiceImpl bankService = new BankServiceImpl();
        BankAccount bankAccount = getBankAccount();

        bankAccount.setBalance(500);
        bankService.withdraw(bankAccount,200);

        assertEquals(bankAccount.getBalance(), 300);

        //bankAccount.setPrevTrans(bankAccount.getPrevTrans());

        //assertEquals(bankAccount.getBalance(),bankAccount.getBalance() - bankAccount.getPrevTrans());

        //assertEquals(bankAccount.getBalance(), 300);


        //assertEquals(bankAccount.getBalance(), (bankAccount.setPrevTrans(bankAccount.getBalance() - bankAccount.getPrevTrans()));


        //assertEquals(bankAccount.getBalance(), bankAccount.setPrevTrans(bankAccount.getBalance() - bankAccount.getPrevTrans()));

        //bankAccount.getPrevTrans();


        //BankMenu bankMenu = new BankMenu(bankService, bankAccount);


    }


    @Test
    void withdrawShouldNotBeAccepted(){

        BankServiceImpl bankService = new BankServiceImpl();
        BankAccount bankAccount = getBankAccount();

        bankAccount.setBalance(100);
        bankService.withdraw(bankAccount,200);

        assertFalse(bankAccount.getBalance()<bankAccount.getPrevTrans(), "Bank balance insufficient");

    }

    @Test
    void depositShouldUpdateBankAccountBalance() {
        BankServiceImpl bankService = new BankServiceImpl();
        BankAccount bankAccount = getBankAccount();

        bankAccount.setBalance(400);
        bankService.deposit(bankAccount,500);

        assertEquals(bankAccount.getBalance(), 900);

    }
}