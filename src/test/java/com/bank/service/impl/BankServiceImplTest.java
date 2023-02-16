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
        double balanceBefore = bankAccount.getBalance();

        double withdrawAmount = 200;
        bankService.withdraw(bankAccount, withdrawAmount);

        assertEquals(bankAccount.getBalance(), balanceBefore - withdrawAmount);

        assertEquals(bankAccount.getPrevTrans(), -withdrawAmount);

    }


    @Test
    void withdrawShouldNotBeAccepted() {

        BankServiceImpl bankService = new BankServiceImpl();
        BankAccount bankAccount = getBankAccount();

        bankAccount.setBalance(100);
        double balanceBefore = bankAccount.getBalance();

        double withdrawAmount = 200;
        bankService.withdraw(bankAccount, withdrawAmount);

        assertEquals(bankAccount.getBalance(), balanceBefore, "Should not be any diff. in balance");

    }

    @Test
    void depositShouldUpdateBankAccountBalance() {
        BankServiceImpl bankService = new BankServiceImpl();
        BankAccount bankAccount = getBankAccount();

        bankAccount.setBalance(400);
        double balanceBefore = bankAccount.getBalance();

        double depositAmount = 500;
        bankService.deposit(bankAccount, depositAmount);

        assertEquals(bankAccount.getBalance(), balanceBefore + depositAmount);

        assertEquals(bankAccount.getPrevTrans(), depositAmount);

    }

    @Test
    void depositWithNegativeNumberShouldNotBeAcceptable() {

        BankServiceImpl bankService = new BankServiceImpl();
        BankAccount bankAccount = getBankAccount();

        bankAccount.setBalance(400);
        double balanceBefore = bankAccount.getBalance();

        double depositAmount = -100;
        bankService.deposit(bankAccount, depositAmount);

        assertEquals(bankAccount.getBalance(), balanceBefore, "Should not be any diff. in balance");

    }

    @Test
    void depositWithZeroShouldNotBeAcceptable() {
        BankServiceImpl bankService = new BankServiceImpl();
        BankAccount bankAccount = getBankAccount();

        bankAccount.setBalance(400);
        double balanceBefore = bankAccount.getBalance();

        double withdrawWithZero = 0;
        bankService.deposit(bankAccount, withdrawWithZero);

        assertEquals(bankAccount.getBalance(), balanceBefore, "Should not be any diff. in balance");
    }
}